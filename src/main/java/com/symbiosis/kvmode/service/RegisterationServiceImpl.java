package com.symbiosis.kvmode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.symbiosis.kvmode.exception.ResourceNotFoundException;
import com.symbiosis.kvmode.model.Registeration;
import com.symbiosis.kvmode.repository.RegisterationRepository;

@Service
public class RegisterationServiceImpl implements RegisterationService {

	@Autowired
	@Qualifier("regRepo")
	private RegisterationRepository regRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Registeration save(Registeration r) {
		// Хешируем пароль перед сохранением, если он есть и ещё не захеширован
		if (r.getPassword() != null && !r.getPassword().isEmpty()) {
			String pwd = r.getPassword();
			if (!isProbablyBCryptHash(pwd)) {
				r.setPassword(passwordEncoder.encode(pwd));
			}
		}
		Registeration saved = regRepo.save(r);
		// не возвращаем хеш на фронт
		if (saved != null) saved.setPassword(null);
		return saved;
	}

	@Override
	public List<Registeration> getAll() {
		List<Registeration> all = regRepo.findAll();
		// Обезопасим: удалим пароль из возвращаемых объектов
		for (Registeration u : all) {
			u.setPassword(null);
		}
		return all;
	}

	@Override
	public Registeration search(int id) {
		Registeration r = regRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with id " + id));
		r.setPassword(null);
		return r;
	}

	@Override
	public void delete(int id) {
		Registeration r = regRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with id " + id));
		regRepo.deleteById(id);
	}

	@Override
	public Registeration update(int id, Registeration r) {
		Registeration rold = regRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with id " + id));
		rold.setAddress(r.getAddress());
		rold.setDateofbirth(r.getDateofbirth());
		rold.setEmail(r.getEmail());
		rold.setPhone(r.getPhone());
		// если пришёл пароль — хешируем перед сохранением
		if (r.getPassword() != null && !r.getPassword().isEmpty()) {
			String pwd = r.getPassword();
			if (!isProbablyBCryptHash(pwd)) {
				rold.setPassword(passwordEncoder.encode(pwd));
			} else {
				rold.setPassword(pwd);
			}
		}
		rold.setName(r.getName());
		Registeration saved = regRepo.save(rold);
		if (saved != null) saved.setPassword(null);
		return saved;
	}

	@Override
	public List<Registeration> login(String email, String password) {
		// Минимальная реализация без изменения репозитория:
		// переберём всех пользователей и сравним пароль через passwordEncoder.matches
		List<Registeration> matched = new ArrayList<>();
		List<Registeration> all = regRepo.findAll();
		for (Registeration u : all) {
			if (u.getEmail() != null && u.getEmail().equalsIgnoreCase(email)) {
				String storedHash = u.getPassword();
				if (storedHash != null && passwordEncoder.matches(password, storedHash)) {
					// Не возвращаем хеш клиенту
					u.setPassword(null);
					matched.add(u);
				}
			}
		}
		return matched;
	}

	@Override
	public long getCount() {
		return regRepo.count();
	}

	// Небольшая эвристика: BCrypt-хеш обычно начинается с $2a$/$2b$/$2y$
	private boolean isProbablyBCryptHash(String s) {
		if (s == null) return false;
		return s.startsWith("$2a$") || s.startsWith("$2b$") || s.startsWith("$2y$");
	}
}

package com.symbiosis.kvmode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.symbiosis.kvmode.model.Registeration;
import com.symbiosis.kvmode.service.RegisterationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterationController {
	@Autowired
	RegisterationService rs;

	@GetMapping("/registeration")
	public List<Registeration> getAll() {
		return rs.getAll();
	}

	@GetMapping("/registeration/count")
	public long getCount() {
		return rs.getCount();
	}

	@PostMapping("/registeration")
	public ResponseEntity<Registeration> register(@RequestBody Registeration r) {
		Registeration rn = rs.save(r);
		if (rn != null) rn.setPassword(null);
		return new ResponseEntity<>(rn, HttpStatus.CREATED);
	}

	@GetMapping("/registeration/{id}")
	public ResponseEntity<Registeration> search(@PathVariable("id") int i) {
		Registeration rn = rs.search(i);
		return new ResponseEntity<>(rn, HttpStatus.OK);
	}

	@DeleteMapping("/registeration/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int i) {
		rs.delete(i);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/registeration/{id}")
	public ResponseEntity<Registeration> update(@PathVariable("id") int i, @RequestBody Registeration r) {
		Registeration rn = rs.update(i, r);
		return new ResponseEntity<>(rn, HttpStatus.OK);
	}

	// Оставляем GET-эндпойнт, чтобы фронт не менять. Сервис теперь сравнивает хеш.
	@GetMapping("/registeration/{em}/{ps}")
	public List<Registeration> login(@PathVariable("em") String em, @PathVariable("ps") String ps) {
		List<Registeration> rn = rs.login(em, ps);
		return rn;
	}
}

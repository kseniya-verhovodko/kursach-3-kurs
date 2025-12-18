package com.symbiosis.kvmode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.symbiosis.kvmode.model.Admin;
import com.symbiosis.kvmode.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	@Qualifier("admRepo")
	private AdminRepository admRepo;

	@Override
	public Admin save(Admin a) {
		// TODO Auto-generated method stub
		return admRepo.save(a);
	}

	@Override
	public Admin login(String em, String ps) {
		// TODO Auto-generated method stub
		return admRepo.findByEmailAndPassword(em, ps);
	}

}

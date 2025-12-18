package com.symbiosis.kvmode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.symbiosis.kvmode.model.Master;
import com.symbiosis.kvmode.repository.MasterRepository;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterRepository masterRepo;

    @Override
    public Master save(Master m) {
        return masterRepo.save(m);
    }

    @Override
    public Master login(String email, String password) {
        return masterRepo.findByEmailAndPassword(email, password);
    }
}
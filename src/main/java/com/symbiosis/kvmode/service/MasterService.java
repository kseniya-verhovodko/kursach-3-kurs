package com.symbiosis.kvmode.service;

import com.symbiosis.kvmode.model.Master;

public interface MasterService {
    Master save(Master m);
    Master login(String email, String password);
}
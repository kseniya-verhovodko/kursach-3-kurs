package com.symbiosis.kvmode.service;

import com.symbiosis.kvmode.model.Admin;

public interface AdminService {
Admin save(Admin a);
Admin login(String em, String ps);
}

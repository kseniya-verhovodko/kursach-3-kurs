package com.symbiosis.kvmode.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.kvmode.model.Admin;

@Repository
@Qualifier("admRepo")
public interface AdminRepository extends JpaRepository<Admin, Integer>{
Admin findByEmailAndPassword(String email, String passsword);
}

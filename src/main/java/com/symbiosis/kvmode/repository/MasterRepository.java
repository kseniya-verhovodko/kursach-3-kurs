package com.symbiosis.kvmode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.symbiosis.kvmode.model.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {
    Master findByEmailAndPassword(String email, String password);
}
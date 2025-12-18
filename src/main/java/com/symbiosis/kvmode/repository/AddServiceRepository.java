package com.symbiosis.kvmode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.kvmode.model.AddService;

@Repository
public interface AddServiceRepository extends JpaRepository<AddService, Integer> {
    
}

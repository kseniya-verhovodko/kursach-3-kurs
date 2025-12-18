package com.symbiosis.kvmode.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.kvmode.model.Registeration;

@Repository
@Qualifier("regRepo")
public interface RegisterationRepository extends JpaRepository<Registeration, Integer>{

	List<Registeration> findAllByEmailAndPassword(String email, String password);
	
}

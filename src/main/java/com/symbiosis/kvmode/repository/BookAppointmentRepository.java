package com.symbiosis.kvmode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.kvmode.model.BookAppointment;

@Repository
public interface BookAppointmentRepository extends JpaRepository<BookAppointment, Integer> {
    
}

// src/main/java/com/symbiosis/kvmode/repository/AppointmentRepository.java
package com.symbiosis.kvmode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.symbiosis.kvmode.model.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByClientEmail(String clientEmail);

    List<Appointment> findByMasterId(int masterId);

    List<Appointment> findByStatus(String status);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = :date AND a.appointmentTime = :time AND a.master.id = :masterId AND a.status = 'BOOKED'")
    List<Appointment> findByDateTimeAndMaster(@Param("date") LocalDate date,
                                              @Param("time") LocalTime time,
                                              @Param("masterId") int masterId);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate >= :startDate ORDER BY a.appointmentDate, a.appointmentTime")
    List<Appointment> findUpcomingAppointments(@Param("startDate") LocalDate startDate);
}
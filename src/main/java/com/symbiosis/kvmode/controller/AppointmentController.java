// src/main/java/com/symbiosis/kvmode/controller/AppointmentController.java
package com.symbiosis.kvmode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.symbiosis.kvmode.model.Appointment;
import com.symbiosis.kvmode.service.AppointmentService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/client/{email}")
    public List<Appointment> getClientAppointments(@PathVariable String email) {
        return appointmentService.getAppointmentsByClientEmail(email);
    }

    @GetMapping("/master/{masterId}")
    public List<Appointment> getMasterAppointments(@PathVariable int masterId) {
        return appointmentService.getAppointmentsByMasterId(masterId);
    }

    @GetMapping("/available")
    public ResponseEntity<?> checkTimeSlotAvailable(
            @RequestParam LocalDate date,
            @RequestParam LocalTime time,
            @RequestParam int masterId) {
        boolean available = appointmentService.isTimeSlotAvailable(date, time, masterId);
        return ResponseEntity.ok().body("{\"available\": " + available + "}");
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/cancel-by-client")
    public ResponseEntity<Appointment> cancelByClient(@PathVariable int id) {
        Appointment appointment = appointmentService.cancelByClient(id);
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}/cancel-by-admin")
    public ResponseEntity<Appointment> cancelByAdmin(@PathVariable int id) {
        Appointment appointment = appointmentService.cancelByAdmin(id);
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}/cancel-by-master")
    public ResponseEntity<Appointment> cancelByMaster(@PathVariable int id) {
        Appointment appointment = appointmentService.cancelByMaster(id);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
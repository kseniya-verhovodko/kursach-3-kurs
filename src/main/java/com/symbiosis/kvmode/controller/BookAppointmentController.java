package com.symbiosis.kvmode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.kvmode.model.BookAppointment;
import com.symbiosis.kvmode.service.BookAppointmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookAppointmentController {

    @Autowired
    BookAppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<BookAppointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/count")
    public long getAppointmentCount() {
        return appointmentService.getAppointmentCount();
    }
    
    @PostMapping("/appointments")
    public ResponseEntity<BookAppointment> bookAppointment(@RequestBody BookAppointment appointment) {
        BookAppointment savedAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<BookAppointment> getAppointmentById(@PathVariable("id") int id) {
        BookAppointment appointment = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") int id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
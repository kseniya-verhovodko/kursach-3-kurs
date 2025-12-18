package com.symbiosis.kvmode.service;

import com.symbiosis.kvmode.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(int id);
    void deleteAppointment(int id);
    List<Appointment> getAppointmentsByClientEmail(String email);
    List<Appointment> getAppointmentsByMasterId(int masterId);
    boolean isTimeSlotAvailable(LocalDate date, LocalTime time, int masterId);
    Appointment cancelByClient(int appointmentId);
    Appointment cancelByAdmin(int appointmentId);
    Appointment cancelByMaster(int appointmentId);
}
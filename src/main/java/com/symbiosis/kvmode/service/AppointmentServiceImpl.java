package com.symbiosis.kvmode.service;

import com.symbiosis.kvmode.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.symbiosis.kvmode.model.Appointment;
import com.symbiosis.kvmode.repository.AppointmentRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        // Проверяем доступность времени
        if (!isTimeSlotAvailable(appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getMaster().getId())) {
            throw new RuntimeException("Это время уже занято. Пожалуйста, выберите другое время.");
        }
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentRepo.deleteById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByClientEmail(String email) {
        return appointmentRepo.findByClientEmail(email);
    }

    @Override
    public List<Appointment> getAppointmentsByMasterId(int masterId) {
        return appointmentRepo.findByMasterId(masterId);
    }

    @Override
    public boolean isTimeSlotAvailable(LocalDate date, LocalTime time, int masterId) {
        List<Appointment> conflicts = appointmentRepo.findByDateTimeAndMaster(date, time, masterId);
        return conflicts.isEmpty();
    }

    @Override
    public Appointment cancelByClient(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setStatus("CANCELLED_BY_CLIENT");
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment cancelByAdmin(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setStatus("CANCELLED_BY_ADMIN");
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment cancelByMaster(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setStatus("CANCELLED_BY_MASTER");
        return appointmentRepo.save(appointment);
    }
}
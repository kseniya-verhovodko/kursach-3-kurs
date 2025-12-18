// src/main/java/com/symbiosis/kvmode/model/Appointment.java
package com.symbiosis.kvmode.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String clientName;
    private String clientEmail;
    private String clientPhone;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String serviceName;
    private double serviceCost;

    private String status; // BOOKED, CANCELLED_BY_CLIENT, CANCELLED_BY_ADMIN, CANCELLED_BY_MASTER, COMPLETED

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;

    // Конструкторы
    public Appointment() {}

    public Appointment(String clientName, String clientEmail, String clientPhone,
                       LocalDate appointmentDate, LocalTime appointmentTime,
                       String serviceName, double serviceCost, Master master) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.master = master;
        this.status = "BOOKED";
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    // Дополнительные полезные методы
    public boolean isBooked() {
        return "BOOKED".equals(status);
    }

    public boolean isCancelled() {
        return status != null && status.startsWith("CANCELLED");
    }

    public boolean isCompleted() {
        return "COMPLETED".equals(status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", serviceName='" + serviceName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
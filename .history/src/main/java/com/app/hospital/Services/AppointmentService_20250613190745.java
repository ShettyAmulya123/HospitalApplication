package com.app.hospital.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.Entity.Appointment;
import com.app.hospital.Repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = getAppointment(id);
        existing.setPatientName(updatedAppointment.getPatientName());
        existing.setDoctorName(updatedAppointment.getDoctorName());
        existing.setDate(updatedAppointment.getDate());
        existing.setTime(updatedAppointment.getTime());
        return appointmentRepo.save(existing);
    }

    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(id);
    }
}
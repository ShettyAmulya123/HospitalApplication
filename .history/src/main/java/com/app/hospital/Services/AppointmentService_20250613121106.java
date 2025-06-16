package com.app.hospital.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.app.hospital.Repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    public Appointmen save(Appointment appointment) {
        return repo.save(appointment);
    }

    public List<Appointment> getAll() {
        return repo.findAll();
    }

    public Appointment getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Appointment removed with id: " + id;
    }

    public Appointment update(Appointment appointment) {
        return repo.save(appointment);
    }
}


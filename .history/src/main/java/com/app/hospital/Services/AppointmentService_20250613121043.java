package com.app.hospital.Services;

package com.app.hospital.service;

import com.app.hospital.entity.Appointment;
import com.app.hospital.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo repo;

    public Appointment save(Appointment appointment) {
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


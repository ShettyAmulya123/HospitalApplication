package com.app.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.Entity.Appointment;
import com.app.hospital.Services.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        return service.update(appointment);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        return service.delete(id);
    }
}


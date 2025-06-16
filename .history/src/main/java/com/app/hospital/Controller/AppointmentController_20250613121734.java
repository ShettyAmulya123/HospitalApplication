package com.app.hospital.Controller;
package com.app.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.app.hospital.Services.AppointmentService;

import com.app.hospital.Entity.Appointment;

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


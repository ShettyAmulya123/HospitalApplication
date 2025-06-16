package com.app.hospital.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}

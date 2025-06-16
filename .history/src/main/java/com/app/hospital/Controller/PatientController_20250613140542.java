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

import com.app.hospital.Entity.Patient;
import com.app.hospital.Services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("")
    public Patient updatePatient(@RequestBody Patient patient) {
        return service.update(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        return service.delete(id);
    }
}

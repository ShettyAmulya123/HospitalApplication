package com.app.hospital.Controller;

package com.app.hospital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.app.hospital.Services.PatientService;

import com.app.hospital.Entity.Patient;

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

    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return service.update(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        return service.delete(id);
    }
}

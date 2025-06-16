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

import com.app.hospital.Entity.Doctor;
import com.app.hospital.Services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return service.update(doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        return service.delete(id);
    }
}

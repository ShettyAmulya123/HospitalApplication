package com.app.hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

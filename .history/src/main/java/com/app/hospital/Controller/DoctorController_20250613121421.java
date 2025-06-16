package com.app.hospital.Controller;

import com.app.hospital.entity.Doctor;
import com.app.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServic service;

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

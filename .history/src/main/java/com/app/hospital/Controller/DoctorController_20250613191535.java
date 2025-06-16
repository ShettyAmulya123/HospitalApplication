package com.app.hospital.Controller;

import com.app.hospital.Entity.Doctor;
import com.app.hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

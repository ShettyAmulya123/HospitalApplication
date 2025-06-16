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

import com.app.hospital.Entity.Doctor;
import com.app.hospital.Services.DoctorService;

@RestController
@RequestMapping("/doctors")
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

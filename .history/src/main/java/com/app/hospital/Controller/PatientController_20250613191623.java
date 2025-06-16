package com.app.hospital.Controller;

import com.app.hospital.Entity.Patient;
import com.app.hospital.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}

package com.app.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.hospital.Entity.Patient;
import com.app.hospital.Services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Create a new patient
    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    // Get all patients (non-paginated)
    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }

    // Update patient
    @PutMapping("/put/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    // Delete patient
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Get patients with pagination and sorting
    @GetMapping("/page")
    public Page<Patient> getAllPatientsPaged(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        return patientService.getAllPatients(page, size, sortBy);
    }
}

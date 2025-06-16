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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.Entity.Patient;
import com.app.hospital.Services.PatientService;

@RestController
@RequestMapping("/patients")
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

    @GetMapping("/patients")
public Page<Patient> getAllPatients(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy
) {
    return patientService.getAllPatients(page, size, sortBy);
}

}

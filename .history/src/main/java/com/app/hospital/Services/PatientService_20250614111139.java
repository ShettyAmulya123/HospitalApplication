package com.app.hospital.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.hospital.Entity.Patient;
import com.app.hospital.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public Patient createPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient getPatient(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existing = getPatient(id);
        existing.setName(updatedPatient.getName());
        existing.setAge(updatedPatient.getAge());
        existing.setGender(updatedPatient.getGender());
        existing.setContactNumber(updatedPatient.getContactNumber());
        return patientRepo.save(existing);
    }

    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }

     public Page<Patient> getAllPatients(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return PatientRepository.findAll(pageable);
    }
}
package com.app.hospital.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.app.hospital.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patien save(Patient patient) {
        return repo.save(patient);
    }

    public List<Patient> getAll() {
        return repo.findAll();
    }

    public Patient getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Patient removed with id: " + id;
    }

    public Patient update(Patient patient) {
        return repo.save(patient);
    }
}

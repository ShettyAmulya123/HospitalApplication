package com.app.hospital.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo repo;

    public Doctor save(Doctor doctor) {
        return repo.save(doctor);
    }

    public List<Doctor> getAll() {
        return repo.findAll();
    }

    public Doctor getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Doctor removed with id: " + id;
    }

    public Doctor update(Doctor doctor) {
        return repo.save(doctor);
    }
}


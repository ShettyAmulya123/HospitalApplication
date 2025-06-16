package com.app.hospital.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.Entity.Doctor;
import com.app.hospital.Repository.DoctorRepository;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Doctor getDoctor(Long id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor existing = getDoctor(id);
        existing.setName(updatedDoctor.getName());
        existing.setSpecialization(updatedDoctor.getSpecialization());
        existing.setPhone(updatedDoctor.getPhone());
        existing.setEmail(updatedDoctor.getEmail());
        return doctorRepo.save(existing);
    }

    public void deleteDoctor(Long id) {
        doctorRepo.deleteById(id);
    }
}
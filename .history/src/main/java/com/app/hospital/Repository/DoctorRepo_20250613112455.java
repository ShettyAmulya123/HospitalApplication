package com.app.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.Entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    
}

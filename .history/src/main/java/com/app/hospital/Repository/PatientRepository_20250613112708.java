package com.app.hospital.Repository;

import com.app.hospital.ntity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}

package com.app.hospital.Repository;

import java.util.List;

import com.app.hospital.Entity.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    @Query("SELECT p FROM Patient p WHERE p.doctor.name = :doctorName")
    List<Patient> findPatientsByDoctorName(@Param("doctorName") String doctorName);

    @Query("SELECT p FROM Patient p ORDER BY p.name ASC")
    List<Patient> sortPatientsByNameAsc();

}

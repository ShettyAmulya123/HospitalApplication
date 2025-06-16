package com.app.hospital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hospital.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> findBySpecialization(@Param("specialization") String specialization);

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.specialization) LIKE LOWER(CONCAT('%', :specialization, '%'))")
    List<Doctor> searchDoctorsBySpecialization(@Param("specialization") String specialization);

}

package com.app.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hospital.Entity.Billing;

public interface  BillingRepository extends JpaRepository<Billing, Long>{
    
    @Query("SELECT b FROM Billing b WHERE b.patient.name = :patientName")
    Lis<Billing> findBillingsByPatientName(@Param("patientName") String patientName);

}

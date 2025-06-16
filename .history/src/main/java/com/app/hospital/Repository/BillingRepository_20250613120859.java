package com.app.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.Entity.Billing;

public interface  BillingRepository extends JpaRepository<Billing, Long>{
    
}

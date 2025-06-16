package com.app.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepo extends JpaRepository<Object, Object><Billing, Long> {
    
}

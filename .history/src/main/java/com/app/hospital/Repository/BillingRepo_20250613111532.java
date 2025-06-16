package com.app.hospital.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepo extends JpaRepositor<Billing, Long> {
    
}

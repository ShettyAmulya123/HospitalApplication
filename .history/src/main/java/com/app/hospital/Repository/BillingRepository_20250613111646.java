package com.app.hospital.repository;

import com.app.hospital.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}

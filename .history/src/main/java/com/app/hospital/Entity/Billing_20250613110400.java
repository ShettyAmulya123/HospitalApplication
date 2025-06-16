package com.app.hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientName;
    private String billingDate;
    private double totalAmount;
    private String paymentMethod;
}


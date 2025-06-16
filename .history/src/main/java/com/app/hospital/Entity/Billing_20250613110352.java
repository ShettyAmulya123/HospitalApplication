package com.app.hospital.Entity;
package com.app.hospital.entity;

import jakarta.persistence.*;
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


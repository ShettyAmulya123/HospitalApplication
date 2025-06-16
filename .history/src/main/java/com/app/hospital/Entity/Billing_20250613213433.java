package com.app.hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientName;
    private String billingDate;
    private double totalAmount;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;
}


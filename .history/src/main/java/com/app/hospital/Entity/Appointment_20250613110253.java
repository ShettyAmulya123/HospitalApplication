package com.app.hospital.Entity;

package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientName;
    private String doctorName;
    private String date;
    private String time;
}


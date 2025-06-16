package com.app.hospital.Entity;

package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String specialization;
    private String phone;
    private String email;
}

package com.app.hospital.Entity;

package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String contactNumber;
}

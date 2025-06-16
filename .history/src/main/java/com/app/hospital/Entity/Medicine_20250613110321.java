package com.app.hospital.Entity;

package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private String expiryDate;
    private double price;
}


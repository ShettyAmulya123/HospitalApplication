package com.app.hospital.Repository;

import com.app.hospital.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
}

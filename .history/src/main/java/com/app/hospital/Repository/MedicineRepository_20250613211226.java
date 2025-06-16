package com.app.hospital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hospital.Entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
    @Query("SELECT m FROM Medicine m WHERE m.expiryDate < :currentDate")
    List<Medicine> findExpiredMedicines(@Param("currentDate") String currentDate);

    
}

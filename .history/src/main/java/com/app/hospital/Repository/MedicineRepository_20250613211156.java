package com.app.hospital.Repository;

import com.app.hospital.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
    @Query("SELECT m FROM Medicine m WHERE m.expiryDate < :currentDate")
    List<Medicine> findExpiredMedicines(@Param("currentDate") String currentDate);

}

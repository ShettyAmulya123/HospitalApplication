package com.app.hospital.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.Entity.Medicine;
import com.app.hospital.Repository.MedicineRepository;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepo;

    public Medicine createMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    public Medicine getMedicine(Long id) {
        return medicineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    public Medicine updateMedicine(Long id, Medicine updatedMedicine) {
        Medicine existing = getMedicine(id);
        existing.setName(updatedMedicine.getName());
        existing.setType(updatedMedicine.getType());
        existing.setExpiryDate(updatedMedicine.getExpiryDate());
        existing.setPrice(updatedMedicine.getPrice());
        return medicineRepo.save(existing);
    }

    public void deleteMedicine(Long id) {
        medicineRepo.deleteById(id);
    }
}

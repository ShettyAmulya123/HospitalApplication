package com.app.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.Entity.Medicine;
import com.app.hospital.Services.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<Medicine> create(@RequestBody Medicine medicine) {
        return new ResponseEntity<>(medicineService.createMedicine(medicine), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> get(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicine(id));
    }

    @GetMapping
    public List<Medicine> getAll() {
        return medicineService.getAllMedicines();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Long id, @RequestBody Medicine medicine) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, medicine));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}

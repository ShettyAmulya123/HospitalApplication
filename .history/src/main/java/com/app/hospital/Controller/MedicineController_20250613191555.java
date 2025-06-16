package com.app.hospital.Controller;

import com.app.hospital.Entity.Medicine;
import com.app.hospital.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
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

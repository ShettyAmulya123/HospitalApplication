package com.app.hospital.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.app.hospital.Services.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService service;

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return service.save(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Medicine updateMedicine(@RequestBody Medicine medicine) {
        return service.update(medicine);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        return service.delete(id);
    }
}

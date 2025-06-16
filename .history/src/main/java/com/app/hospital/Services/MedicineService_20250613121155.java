package com.app.hospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.app.hospital.Repository.MedicineRepository;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repo;

    public Medicin save(Medicine medicine) {
        return repo.save(medicine);
    }

    public List<Medicine> getAll() {
        return repo.findAll();
    }

    public Medicine getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Medicine removed with id: " + id;
    }

    public Medicine update(Medicine medicine) {
        return repo.save(medicine);
    }
}

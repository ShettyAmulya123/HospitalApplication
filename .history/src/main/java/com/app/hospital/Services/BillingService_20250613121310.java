package com.app.hospital.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.app.hospital.Entity.Billing;
import com.app.hospital.Repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repo;

    public Billing save(Billing billing) {
        return repo.save(billing);
    }

    public List<Billing> getAll() {
        return repo.findAll();
    }

    public Billing getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Billing record removed with id: " + id;
    }

    public Billing update(Billing billing) {
        return repo.save(billing);
    }
}


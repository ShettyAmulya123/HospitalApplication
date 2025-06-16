package com.app.hospital.Services;

package com.app.hospital.service;

import com.app.hospital.entity.Billing;
import com.app.hospital.repository.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepo repo;

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


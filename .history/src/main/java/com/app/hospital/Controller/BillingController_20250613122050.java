package com.app.hospital.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingServic service;

    @PostMapping
    public Billing addBilling(@RequestBody Billing billing) {
        return service.save(billing);
    }

    @GetMapping
    public List<Billing> getAllBillings() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Billing getBilling(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Billing updateBilling(@RequestBody Billing billing) {
        return service.update(billing);
    }

    @DeleteMapping("/{id}")
    public String deleteBilling(@PathVariable Long id) {
        return service.delete(id);
    }
}

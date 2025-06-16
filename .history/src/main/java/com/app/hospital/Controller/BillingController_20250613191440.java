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

import com.app.hospital.Entity.Billing;
import com.app.hospital.Services.BillingService;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<Billing> create(@RequestBody Billing billing) {
        return new ResponseEntity<>(billingService.createBilling(billing), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> get(@PathVariable Long id) {
        return ResponseEntity.ok(billingService.getBilling(id));
    }

    @GetMapping
    public List<Billing> getAll() {
        return billingService.getAllBillings();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Billing> update(@PathVariable Long id, @RequestBody Billing billing) {
        return ResponseEntity.ok(billingService.updateBilling(id, billing));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        billingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }
}

package com.app.hospital.Controller;

import com.app.hospital.Entity.Billing;
import com.app.hospital.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

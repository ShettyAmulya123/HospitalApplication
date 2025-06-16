package com.app.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.Entity.Billing;
import com.app.hospital.Repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepo;

    public Billing createBilling(Billing billing) {
        return billingRepo.save(billing);
    }

    public Billing getBilling(Long id) {
        return billingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Billing not found"));
    }

    public List<Billing> getAllBillings() {
        return billingRepo.findAll();
    }

    public Billing updateBilling(Long id, Billing updatedBilling) {
        Billing existing = getBilling(id);
        existing.setPatientName(updatedBilling.getPatientName());
        existing.setBillingDate(updatedBilling.getBillingDate());
        existing.setTotalAmount(updatedBilling.getTotalAmount());
        existing.setPaymentMethod(updatedBilling.getPaymentMethod());
        return billingRepo.save(existing);
    }

    public void deleteBilling(Long id) {
        billingRepo.deleteById(id);
    }
}

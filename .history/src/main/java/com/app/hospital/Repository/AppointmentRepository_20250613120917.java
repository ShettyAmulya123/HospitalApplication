package com.app.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}

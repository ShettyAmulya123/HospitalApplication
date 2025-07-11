package com.app.hospital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hospital.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
    @Query("SELECT a FROM Appointment a WHERE a.doctorName = :doctorName AND a.date = :date")
    List<Appointment> findByDoctorAndDate(@Param("doctorName") String doctorName, @Param("date") String date);

}

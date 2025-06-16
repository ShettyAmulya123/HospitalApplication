package com.app.hospital.Controller;

package com.app.hospital.Controller;

import com.app.hospital.Entity.Appointment;
import com.app.hospital.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}

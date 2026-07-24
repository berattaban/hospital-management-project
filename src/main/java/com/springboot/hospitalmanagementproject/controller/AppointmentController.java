package com.springboot.hospitalmanagementproject.controller;

import com.springboot.hospitalmanagementproject.dto.request.AppointmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.AppointmentResponse;
import com.springboot.hospitalmanagementproject.service.impl.AppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentServiceImpl appointmentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAppointment(@RequestBody AppointmentCreateRequest request){
         appointmentService.createAppointment(request);
         return ResponseEntity.ok("Appointment Created");
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments(){
        return ResponseEntity.ok(appointmentService.getAppointments());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable UUID id){
        appointmentService.cancelAppointment(id);
        return ResponseEntity.ok("Appointment Deleted");
    }

    @GetMapping("/get-from-doctor-id/{id}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByDoctorId(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorId(id));
    }

    @GetMapping("/get-from-patient-id/{id}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByPatientId(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientId(id));
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllAppointments(){
        appointmentService.deleteAllAppointments();
        return ResponseEntity.ok("Appointments Deleted");
    }
}

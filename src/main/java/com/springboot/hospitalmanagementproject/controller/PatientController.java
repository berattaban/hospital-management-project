package com.springboot.hospitalmanagementproject.controller;

import com.springboot.hospitalmanagementproject.dto.request.PatientCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.PatientResponse;
import com.springboot.hospitalmanagementproject.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientServiceImpl  patientService;

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody PatientCreateRequest request){
        patientService.createPatient(request);
        return ResponseEntity.ok().body("Patient created successfully");
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PatientResponse>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.findAllPatients());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("Patient deleted successfully");
    }
}

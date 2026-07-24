package com.springboot.hospitalmanagementproject.controller;

import com.springboot.hospitalmanagementproject.dto.request.HospitalCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.HospitalResponse;
import com.springboot.hospitalmanagementproject.service.impl.HospitalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalServiceImpl hospitalService;

    @PostMapping("/create")
    public ResponseEntity<String> createHospital(@RequestBody HospitalCreateRequest request){
        hospitalService.createHospital(request);
        return ResponseEntity.ok().body("Hospital created successfully");
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<HospitalResponse>> getAllHospitals(){
        return ResponseEntity.ok().body(hospitalService.getAllHospitals());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHospitalById(@PathVariable Long id){
        hospitalService.deleteHospitalById(id);
        return ResponseEntity.ok().body("Hospital deleted successfully");
    }
}

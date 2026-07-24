package com.springboot.hospitalmanagementproject.controller;

import com.springboot.hospitalmanagementproject.dto.request.DoctorCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DoctorResponse;
import com.springboot.hospitalmanagementproject.service.impl.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServiceImpl doctorService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDoctor(@RequestBody DoctorCreateRequest request){
        doctorService.createDoctor(request);
        return new ResponseEntity<>("Doctor created successfully", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DoctorResponse>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted");
    }
}

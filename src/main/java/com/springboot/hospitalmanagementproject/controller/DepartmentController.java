package com.springboot.hospitalmanagementproject.controller;

import com.springboot.hospitalmanagementproject.dto.request.DepartmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DepartmentResponse;
import com.springboot.hospitalmanagementproject.service.impl.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentCreateRequest request){
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department has been deleted");
    }
}

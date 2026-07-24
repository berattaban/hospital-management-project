package com.springboot.hospitalmanagementproject.service;

import com.springboot.hospitalmanagementproject.dto.request.DepartmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {

  DepartmentResponse createDepartment(DepartmentCreateRequest request);
  List<DepartmentResponse> findAllDepartments();
  void deleteDepartment(Long id);
}

package com.springboot.hospitalmanagementproject.service.impl;

import com.springboot.hospitalmanagementproject.dto.request.DepartmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DepartmentResponse;
import com.springboot.hospitalmanagementproject.entity.Department;
import com.springboot.hospitalmanagementproject.entity.Hospital;
import com.springboot.hospitalmanagementproject.mapper.DepartmentMapper;
import com.springboot.hospitalmanagementproject.repository.DepartmentRepository;
import com.springboot.hospitalmanagementproject.repository.HospitalRepository;
import com.springboot.hospitalmanagementproject.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final HospitalRepository hospitalRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {

        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(()-> new IllegalArgumentException("Hospital Not Found"));

        Department department = Department.builder()
                .name(request.getName())
                .description(request.getDescription())
                .hospital(hospital)
                .build();

        Department savedDepartment = departmentRepository.save(department);

        return departmentMapper.mapToResponse(savedDepartment);

    }

    @Override
    public List<DepartmentResponse> findAllDepartments() {
        return departmentMapper.mapToResponseList(departmentRepository.findAll());
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}

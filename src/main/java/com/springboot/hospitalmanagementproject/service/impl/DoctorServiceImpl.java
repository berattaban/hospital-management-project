package com.springboot.hospitalmanagementproject.service.impl;

import com.springboot.hospitalmanagementproject.dto.request.DoctorCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DoctorResponse;
import com.springboot.hospitalmanagementproject.entity.Department;
import com.springboot.hospitalmanagementproject.entity.Doctor;
import com.springboot.hospitalmanagementproject.mapper.DoctorMapper;
import com.springboot.hospitalmanagementproject.repository.DepartmentRepository;
import com.springboot.hospitalmanagementproject.repository.DoctorRepository;
import com.springboot.hospitalmanagementproject.service.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements IDoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(()-> new RuntimeException("Department not found with id: " + request.getDepartmentId()));



        Doctor doctor = Doctor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .specialization(request.getSpecialization())
                .department(department)
                .build();

        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.mapToResponse(savedDoctor);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorMapper.mapToResponseList(doctorRepository.findAll());
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}

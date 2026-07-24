package com.springboot.hospitalmanagementproject.service;

import com.springboot.hospitalmanagementproject.dto.request.DoctorCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DoctorResponse;

import java.util.List;

public interface IDoctorService {

    DoctorResponse createDoctor(DoctorCreateRequest request);
    List<DoctorResponse> getAllDoctors();
    void deleteDoctor(Long id);
}

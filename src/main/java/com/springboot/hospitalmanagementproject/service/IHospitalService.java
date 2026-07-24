package com.springboot.hospitalmanagementproject.service;

import com.springboot.hospitalmanagementproject.dto.request.HospitalCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.HospitalResponse;

import java.util.List;

public interface IHospitalService {

    HospitalResponse createHospital(HospitalCreateRequest request);
    List<HospitalResponse> getAllHospitals();
    void deleteHospitalById(Long id);
}

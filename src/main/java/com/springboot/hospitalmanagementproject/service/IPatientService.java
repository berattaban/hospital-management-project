package com.springboot.hospitalmanagementproject.service;

import com.springboot.hospitalmanagementproject.dto.request.PatientCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.PatientResponse;

import java.util.List;

public interface IPatientService {

    PatientResponse createPatient(PatientCreateRequest request);
    List<PatientResponse> findAllPatients();
    void deletePatient(Long id);
}

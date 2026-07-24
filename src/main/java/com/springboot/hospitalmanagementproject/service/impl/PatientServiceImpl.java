package com.springboot.hospitalmanagementproject.service.impl;

import com.springboot.hospitalmanagementproject.dto.request.PatientCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.PatientResponse;
import com.springboot.hospitalmanagementproject.entity.Patient;
import com.springboot.hospitalmanagementproject.mapper.PatientMapper;
import com.springboot.hospitalmanagementproject.repository.PatientRepository;
import com.springboot.hospitalmanagementproject.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .identityNumber(request.getIdentityNumber())
                .build();

        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.mapToResponse(savedPatient);
    }

    @Override
    public List<PatientResponse> findAllPatients() {
        return patientMapper.mapToResponseList(patientRepository.findAll());
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

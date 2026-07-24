package com.springboot.hospitalmanagementproject.service.impl;

import com.springboot.hospitalmanagementproject.dto.request.HospitalCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.HospitalResponse;
import com.springboot.hospitalmanagementproject.entity.Hospital;
import com.springboot.hospitalmanagementproject.mapper.HospitalMapper;
import com.springboot.hospitalmanagementproject.repository.HospitalRepository;
import com.springboot.hospitalmanagementproject.service.IHospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements IHospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;

    @Override
    public HospitalResponse createHospital(HospitalCreateRequest request) {
        Hospital hospital = Hospital.builder()
                .hospitalName(request.getHospitalName())
                .hospitalEmail(request.getHospitalEmail())
                .hospitalPhone(request.getHospitalPhone())
                .hospitalAddress(request.getHospitalAddress())
                .build();

        Hospital savedHospital = hospitalRepository.save(hospital);

        return HospitalResponse.builder()
                .id(savedHospital.getId())
                .hospitalName(savedHospital.getHospitalName())
                .hospitalAddress(savedHospital.getHospitalAddress())
                .hospitalPhone(savedHospital.getHospitalPhone())
                .hospitalEmail(savedHospital.getHospitalEmail())
                .build();
    }

    @Override
    public List<HospitalResponse> getAllHospitals() {
        return hospitalMapper.mapToResponseList(hospitalRepository.findAll());
    }

    @Override
    public void deleteHospitalById(Long id) {
        hospitalRepository.deleteById(id);
    }
}

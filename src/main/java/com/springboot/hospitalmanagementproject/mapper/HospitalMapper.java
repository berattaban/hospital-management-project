package com.springboot.hospitalmanagementproject.mapper;

import com.springboot.hospitalmanagementproject.dto.request.HospitalCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.HospitalResponse;
import com.springboot.hospitalmanagementproject.entity.Hospital;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospitalMapper {

    HospitalResponse mapToResponse(Hospital hospital);
    Hospital mapToEntity(HospitalCreateRequest request);
    List<HospitalResponse> mapToResponseList(List<Hospital> hospitals);
}

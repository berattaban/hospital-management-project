package com.springboot.hospitalmanagementproject.mapper;

import com.springboot.hospitalmanagementproject.dto.request.DoctorCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DoctorResponse;
import com.springboot.hospitalmanagementproject.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.hospital.id", target = "hospitalId")
    DoctorResponse mapToResponse(Doctor doctor);

    Doctor mapToEntity(DoctorCreateRequest request);
    List<DoctorResponse> mapToResponseList(List<Doctor> doctors);
}

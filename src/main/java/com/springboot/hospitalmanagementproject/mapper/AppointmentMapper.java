package com.springboot.hospitalmanagementproject.mapper;

import com.springboot.hospitalmanagementproject.dto.request.AppointmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.AppointmentResponse;
import com.springboot.hospitalmanagementproject.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.id", target = "doctorId")
    AppointmentResponse mapToResponse(Appointment appointment);

    Appointment mapToEntity(AppointmentCreateRequest request);
    List<AppointmentResponse> mapToResponseList(List<Appointment> appointments);

}

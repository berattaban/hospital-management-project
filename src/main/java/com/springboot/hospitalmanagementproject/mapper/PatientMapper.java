package com.springboot.hospitalmanagementproject.mapper;

import com.springboot.hospitalmanagementproject.dto.request.PatientCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.AppointmentSummaryResponse;
import com.springboot.hospitalmanagementproject.dto.response.PatientResponse;
import com.springboot.hospitalmanagementproject.entity.Appointment;
import com.springboot.hospitalmanagementproject.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientResponse mapToResponse(Patient patient);
    Patient mapToEntity(PatientCreateRequest request);
    List<PatientResponse> mapToResponseList(List<Patient> patients);

    @Mapping(source = "doctor.id", target = "doctorId")
    AppointmentSummaryResponse mapToResponseAppointmentSummary(Appointment appointment);

}

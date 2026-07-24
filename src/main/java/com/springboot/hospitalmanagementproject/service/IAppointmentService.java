package com.springboot.hospitalmanagementproject.service;

import com.springboot.hospitalmanagementproject.dto.request.AppointmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.AppointmentResponse;

import java.util.List;
import java.util.UUID;

public interface IAppointmentService {

    AppointmentResponse createAppointment(AppointmentCreateRequest request);
    List<AppointmentResponse> getAppointments();
    void cancelAppointment(UUID id);
    List<AppointmentResponse> getAppointmentsByDoctorId(Long id);
    List<AppointmentResponse> getAppointmentsByPatientId(Long id);
    void deleteAllAppointments();
}

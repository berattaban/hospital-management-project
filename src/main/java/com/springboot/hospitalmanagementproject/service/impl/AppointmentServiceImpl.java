package com.springboot.hospitalmanagementproject.service.impl;

import com.springboot.hospitalmanagementproject.dto.request.AppointmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.AppointmentResponse;
import com.springboot.hospitalmanagementproject.entity.Appointment;
import com.springboot.hospitalmanagementproject.entity.Doctor;
import com.springboot.hospitalmanagementproject.entity.Patient;
import com.springboot.hospitalmanagementproject.mapper.AppointmentMapper;
import com.springboot.hospitalmanagementproject.repository.AppointmentRepository;
import com.springboot.hospitalmanagementproject.repository.DoctorRepository;
import com.springboot.hospitalmanagementproject.repository.PatientRepository;
import com.springboot.hospitalmanagementproject.service.IAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Override
    public AppointmentResponse createAppointment(AppointmentCreateRequest request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient Not Found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor Not Found"));

        Appointment appointment = Appointment.builder()
                .appointmentDate(request.getAppointmentDate())
                .status(request.getStatus())
                .patient(patient)
                .doctor(doctor)
                .department(doctor.getDepartment())
                .hospital(doctor.getDepartment().getHospital())
                .build();

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return appointmentMapper.mapToResponse(savedAppointment);
    }

    @Override
    public List<AppointmentResponse> getAppointments() {
        return appointmentMapper.mapToResponseList(appointmentRepository.findAll());
    }

    @Override
    public void cancelAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByDoctorId(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        List<AppointmentResponse> responses = new ArrayList<>();
        for (Appointment appointment : doctor.getAppointments()) {
            AppointmentResponse dto = new AppointmentResponse();
            dto.setId(appointment.getId());
            dto.setAppointmentDate(appointment.getAppointmentDate());
            dto.setStatus(appointment.getStatus());
            dto.setPatientId(appointment.getPatient().getId());
            dto.setDoctorId(appointment.getDoctor().getId());
            responses.add(dto);
        }
        return responses;
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatientId(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        List<AppointmentResponse> responses = new ArrayList<>();
        for (Appointment appointment : patient.getAppointments()) {
            AppointmentResponse dto = new AppointmentResponse();
            dto.setId(appointment.getId());
            dto.setAppointmentDate(appointment.getAppointmentDate());
            dto.setStatus(appointment.getStatus());
            dto.setPatientId(appointment.getPatient().getId());
            dto.setDoctorId(appointment.getDoctor().getId());
            responses.add(dto);

        }
        return responses;
    }

    @Override
    public void deleteAllAppointments() {
        appointmentRepository.deleteAll();
    }
}

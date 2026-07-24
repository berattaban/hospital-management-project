package com.springboot.hospitalmanagementproject.dto.request;

import com.springboot.hospitalmanagementproject.entity.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentCreateRequest {

    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private Long patientId;
    private Long doctorId;
}

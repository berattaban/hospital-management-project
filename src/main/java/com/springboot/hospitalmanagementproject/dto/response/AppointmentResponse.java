package com.springboot.hospitalmanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.hospitalmanagementproject.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonPropertyOrder({"id","appointmentDate","status","patientId","doctorId",})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private UUID id;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private Long patientId;
    private Long doctorId;
}

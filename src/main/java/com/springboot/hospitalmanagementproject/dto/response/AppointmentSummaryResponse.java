package com.springboot.hospitalmanagementproject.dto.response;

import com.springboot.hospitalmanagementproject.entity.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSummaryResponse {

    private UUID id;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private Long doctorId;
}

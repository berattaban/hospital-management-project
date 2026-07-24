package com.springboot.hospitalmanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.hospitalmanagementproject.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonPropertyOrder({"id","firstName","lastName","email","phoneNumber","identityNumber","appointments"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String identityNumber;

    private List<AppointmentSummaryResponse> appointments;

}

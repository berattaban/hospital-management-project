package com.springboot.hospitalmanagementproject.dto.request;

import com.springboot.hospitalmanagementproject.entity.Appointment;
import lombok.Data;

import java.util.List;

@Data
public class PatientCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String identityNumber;

}

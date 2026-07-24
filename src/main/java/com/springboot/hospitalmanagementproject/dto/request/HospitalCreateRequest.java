package com.springboot.hospitalmanagementproject.dto.request;

import lombok.Data;

@Data
public class HospitalCreateRequest {

    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhone;
    private String hospitalEmail;
}

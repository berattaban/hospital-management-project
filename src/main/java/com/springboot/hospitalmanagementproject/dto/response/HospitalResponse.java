package com.springboot.hospitalmanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","hospitalName","hospitalPhone","hospitalEmail","hospitalAddress"})
@Builder
public class HospitalResponse {

    private Long id;
    private String hospitalName;
    private String hospitalPhone;
    private String hospitalEmail;
    private String hospitalAddress;
}

package com.springboot.hospitalmanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.hospitalmanagementproject.entity.Department;
import com.springboot.hospitalmanagementproject.entity.Specialization;
import lombok.Builder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","firstName","lastName","specialization","departmentId","hospitalId"})
@Builder
public class DoctorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private Specialization specialization;
    private Long departmentId;
    private Long hospitalId;
}

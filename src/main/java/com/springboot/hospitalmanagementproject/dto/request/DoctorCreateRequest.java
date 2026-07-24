package com.springboot.hospitalmanagementproject.dto.request;

import com.springboot.hospitalmanagementproject.entity.Department;
import com.springboot.hospitalmanagementproject.entity.Specialization;
import lombok.Data;

@Data
public class DoctorCreateRequest {

    private String firstName;
    private String lastName;
    private Specialization specialization;
    private Long departmentId;
    private Long hospitalId;
}

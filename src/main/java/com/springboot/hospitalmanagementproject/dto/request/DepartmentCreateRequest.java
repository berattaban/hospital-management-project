package com.springboot.hospitalmanagementproject.dto.request;

import lombok.Data;

@Data
public class DepartmentCreateRequest {

    private String name;
    private String description;
    private Long hospitalId;
}


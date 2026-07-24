package com.springboot.hospitalmanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.hospitalmanagementproject.entity.Doctor;
import com.springboot.hospitalmanagementproject.entity.Hospital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonPropertyOrder({"id", "name", "description", "hospitalId", "hospitalName"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {

    private Long id;
    private String name;
    private String description;
    private Long hospitalId;
    private String hospitalName;

}

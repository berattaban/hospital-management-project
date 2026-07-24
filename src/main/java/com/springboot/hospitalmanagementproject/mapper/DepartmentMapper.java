package com.springboot.hospitalmanagementproject.mapper;

import com.springboot.hospitalmanagementproject.dto.request.DepartmentCreateRequest;
import com.springboot.hospitalmanagementproject.dto.response.DepartmentResponse;
import com.springboot.hospitalmanagementproject.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "hospital.id", target = "hospitalId")
    @Mapping(source = "hospital.hospitalName", target = "hospitalName")
    DepartmentResponse mapToResponse(Department department);

    Department mapToEntity(DepartmentCreateRequest request);
    List<DepartmentResponse> mapToResponseList(List<Department> departmentList);
}

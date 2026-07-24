package com.springboot.hospitalmanagementproject.repository;

import com.springboot.hospitalmanagementproject.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}

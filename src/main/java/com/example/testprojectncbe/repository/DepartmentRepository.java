package com.example.testprojectncbe.repository;

import com.example.testprojectncbe.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

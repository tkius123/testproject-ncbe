package com.example.testprojectncbe.repository;

import com.example.testprojectncbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

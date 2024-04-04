package com.example.testprojectncbe.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private EmployeeType type;

    private boolean isFullTime;

    @ManyToOne
    private Department department;
}

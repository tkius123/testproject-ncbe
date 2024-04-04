package com.example.testprojectncbe.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Nullable
    private Boolean isFullTime;

    @ManyToOne
    private Department department;
}

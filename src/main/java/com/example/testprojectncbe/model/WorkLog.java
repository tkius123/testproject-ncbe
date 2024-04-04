package com.example.testprojectncbe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weekId;

    @ManyToOne
    private Employee employee;

    private int hoursWorked;
}

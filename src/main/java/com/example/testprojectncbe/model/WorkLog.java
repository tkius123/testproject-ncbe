package com.example.testprojectncbe.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WeekLong weekLong;

    @ManyToOne
    private Employee employee;

    private double hoursWorked;
}

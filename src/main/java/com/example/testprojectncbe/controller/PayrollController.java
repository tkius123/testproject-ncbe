package com.example.testprojectncbe.controller;

import com.example.testprojectncbe.service.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping("/employeePayments/{weekId}")
    public ResponseEntity<Map<Long, Double>> getEmployeePayments(@PathVariable Long weekId) {
        Map<Long, Double> payments = payrollService.getPaymentsByEmployee(weekId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/departmentPaymentsSorted/{weekId}")
    public ResponseEntity<LinkedHashMap<String, Double>> getDepartmentPaymentsSorted(@PathVariable Long weekId) {
        LinkedHashMap<String, Double> payments = payrollService.getPaymentsByDepartmentSorted(weekId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/baseSalaries")
    public ResponseEntity<Map<Long, Double>> getBaseSalaries() {
        Map<Long, Double> baseSalaries = payrollService.getBaseSalaries();
        return ResponseEntity.ok(baseSalaries);
    }
}

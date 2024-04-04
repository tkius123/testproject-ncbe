package com.example.testprojectncbe.service;

import com.example.testprojectncbe.model.Employee;
import com.example.testprojectncbe.model.EmployeeType;
import com.example.testprojectncbe.model.WorkLog;
import com.example.testprojectncbe.repository.DepartmentRepository;
import com.example.testprojectncbe.repository.EmployeeRepository;
import com.example.testprojectncbe.repository.WorkLogRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PayrollService {

    private final EmployeeRepository employeeRepository;

    private final WorkLogRepository workLogRepository;

    private final DepartmentRepository departmentRepository;

    public PayrollService(EmployeeRepository employeeRepository, WorkLogRepository workLogRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.workLogRepository = workLogRepository;
        this.departmentRepository = departmentRepository;
    }

    private static final double overtimeMultiplier = 1.5;

    private static final Map<EmployeeType, Double> baseRates = Map.of(
            EmployeeType.INTERN, 10.0,
            EmployeeType.FLOOR_WORKER, 20.0,
            EmployeeType.SUPERVISOR, 25.0,
            EmployeeType.MANAGER, 35.0,
            EmployeeType.EXECUTIVE, 50.0
    );

    // under assumption that an employee has at 1 work log for each week
    // return payments for given week for all employees. key is employee id, value is payment
    // return 0 if no work log
    public Map<Long, Double> getPaymentsByEmployee(Long weekId) {
        Map<Long, Double> map = workLogRepository.findByWeekLongId(weekId).stream().collect(
                Collectors.toMap(wl -> wl.getEmployee().getId(), this::calculatePay, Double::sum)
        );

        return employeeRepository.findAll().stream().collect(
                Collectors.toMap(Employee::getId, emp -> map.getOrDefault(emp.getId(), 0.0)));
    }

    // return payments for given week for all departments. order by payment desc, department name.
    // key is department name, value is payment
    // return 0 if no work log
    public LinkedHashMap<String, Double> getPaymentsByDepartmentSorted(Long weekId) {
        Map<String, Double> map = workLogRepository.findByWeekLongId(weekId).stream().collect(
                Collectors.groupingBy(wl -> wl.getEmployee().getDepartment().getName(), Collectors.summingDouble(this::calculatePay))
        );

        departmentRepository.findAll().forEach(dept -> map.putIfAbsent(dept.getName(), 0.0));

        return map.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    // return base salary of all employees order by name
    public LinkedHashMap<Long, Double> getBaseSalaries() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toMap(
                        Employee::getId,
                        emp -> baseRates.get(emp.getType()),
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    private double calculatePay(WorkLog workLog) {
        double baseRate = baseRates.get(workLog.getEmployee().getType());
        double regularHours = Math.min(workLog.getHoursWorked(), 40);
        double overtimeHours = Math.max(workLog.getHoursWorked() - 40, 0);

        double regularPay = regularHours * baseRate;
        double overtimePay = overtimeHours * baseRate * overtimeMultiplier;

        return regularPay + overtimePay;
    }
}

package com.example.testprojectncbe.controller;

import com.example.testprojectncbe.model.WorkLog;
import com.example.testprojectncbe.repository.WorkLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worklogs")
public class WorkLogController {
    private final WorkLogRepository workLogRepository;

    public WorkLogController(WorkLogRepository workLogRepository) {
        this.workLogRepository = workLogRepository;
    }

    @GetMapping
    public ResponseEntity<List<WorkLog>> getAllWorkLogs() {
        List<WorkLog> workLogs = workLogRepository.findAll();
        return new ResponseEntity<>(workLogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkLog> getWorkLogById(@PathVariable Long id) {
        WorkLog workLog = workLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkLog not found with id " + id));
        return new ResponseEntity<>(workLog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkLog> createWorkLog(@RequestBody WorkLog workLog) {
        WorkLog newWorkLog = workLogRepository.save(workLog);
        return new ResponseEntity<>(newWorkLog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkLog> updateWorkLog(@PathVariable Long id, @RequestBody WorkLog workLogDetails) {
        workLogDetails.setId(id);
        WorkLog updatedWorkLog = workLogRepository.save(workLogDetails);
        return new ResponseEntity<>(updatedWorkLog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkLog(@PathVariable Long id) {
        workLogRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

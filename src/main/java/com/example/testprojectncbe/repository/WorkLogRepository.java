package com.example.testprojectncbe.repository;

import com.example.testprojectncbe.model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {
}

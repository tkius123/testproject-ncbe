package com.example.testprojectncbe.repository;

import com.example.testprojectncbe.model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {
    List<WorkLog> findByWeekId(Long weekId);
}

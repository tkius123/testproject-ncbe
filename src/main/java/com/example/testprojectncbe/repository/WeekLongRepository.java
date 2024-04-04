package com.example.testprojectncbe.repository;

import com.example.testprojectncbe.model.WeekLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface WeekLongRepository extends JpaRepository<WeekLong, Long> {
    @Query("SELECT w.id FROM WeekLong w WHERE :date >= w.weekStart AND :date < w.weekEnd")
    Long findWeekIdByDate(@Param("date") LocalDate date);
}

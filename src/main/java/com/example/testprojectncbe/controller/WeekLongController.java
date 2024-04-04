package com.example.testprojectncbe.controller;

import com.example.testprojectncbe.model.WeekLong;
import com.example.testprojectncbe.repository.WeekLongRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weeklong")
public class WeekLongController {
    private final WeekLongRepository weekLongRepository;

    public WeekLongController(WeekLongRepository weekLongRepository) {
        this.weekLongRepository = weekLongRepository;
    }

    @GetMapping
    public ResponseEntity<List<WeekLong>> getAllWeekLong() {
        List<WeekLong> WeekLongList = weekLongRepository.findAll();
        return new ResponseEntity<>(WeekLongList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeekLong> getWeekLongByWeekId(@PathVariable Long id) {
        WeekLong weekLong = weekLongRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(weekLong, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WeekLong> createWeekLong(@RequestBody WeekLong weekLong) {
        WeekLong newWeekLong = weekLongRepository.save(weekLong);
        return new ResponseEntity<>(newWeekLong, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeekLong> updateWeekLong(@PathVariable Long id, @RequestBody WeekLong weekLong) {
        weekLong.setId(id);
        WeekLong updatedWeekLong = weekLongRepository.save(weekLong);
        return new ResponseEntity<>(updatedWeekLong, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWeekLong(@PathVariable Long id) {
        weekLongRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get Week ID by Date", description = "Returns the ID of the week containing the provided date.")
    @GetMapping("/weekId")
    public ResponseEntity<Long> getWeekIdByDate(
            @Parameter(description = "Date in the format yyyy-MM-dd", example = "2024-01-01", in = ParameterIn.QUERY)
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Long weekId = weekLongRepository.findWeekIdByDate(date);
        if (weekId != null) {
            return new ResponseEntity<>(weekId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

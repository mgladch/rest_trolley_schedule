package com.hladchuk.controller;

import com.hladchuk.model.Schedule;
import com.hladchuk.service.ScheduleService;
import com.hladchuk.mapper.postmapper.PostScheduleMapper;
import com.hladchuk.model.dto.postdto.PostScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class ScheduleController {
    ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping("/schedules")
    public ResponseEntity<List<PostScheduleDto>> findAll() {
        return ResponseEntity.ok(PostScheduleMapper.INSTANCE.scheduleToPostScheduleDtos(scheduleService.findAll()));
    }

    @PostMapping("/schedules")
    public ResponseEntity<PostScheduleDto> create(@RequestBody PostScheduleDto postScheduleDto) {
        scheduleService.save(PostScheduleMapper.INSTANCE.postDtoToSchedule(postScheduleDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(postScheduleDto);
    }

    @GetMapping(value = "/scheduleById/{id}")
    public ResponseEntity<PostScheduleDto> findById(@PathVariable int id) {
        Optional<Schedule> schedule = scheduleService.findById(id);

        return ResponseEntity.ok(PostScheduleMapper.INSTANCE.toPostDto(schedule.get()));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<PostScheduleDto> update(@PathVariable int id, @RequestBody PostScheduleDto postScheduleDto) {
        Schedule schedule = PostScheduleMapper.INSTANCE.postDtoToSchedule(postScheduleDto);
        schedule.setId(id);

        scheduleService.save(schedule);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postScheduleDto);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        scheduleService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

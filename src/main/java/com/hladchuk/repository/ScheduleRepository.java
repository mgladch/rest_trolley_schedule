package com.hladchuk.repository;

import com.hladchuk.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}

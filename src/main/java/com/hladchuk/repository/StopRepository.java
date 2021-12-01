package com.hladchuk.repository;

import com.hladchuk.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop,Integer> {
    Stop findByName(String name);
}

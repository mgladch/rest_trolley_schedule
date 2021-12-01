package com.hladchuk.repository;

import com.hladchuk.model.transport.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

}

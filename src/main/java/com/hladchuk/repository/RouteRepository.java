package com.hladchuk.repository;

import com.hladchuk.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer> {
    List<Route> findAllByNumber(int number);
    List<Route> findAllByName(String title);
    Route findByName(String name);
}

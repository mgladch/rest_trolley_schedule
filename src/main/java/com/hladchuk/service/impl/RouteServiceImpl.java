package com.hladchuk.service.impl;

import com.hladchuk.model.Route;
import com.hladchuk.service.RouteService;
import com.hladchuk.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route save(Route object) {
        return routeRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Optional<Route> findById(Integer id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> findAllByNumber(int number) {
        return routeRepository.findAllByNumber(number);
    }


    @Override
    public Route findByName(String name) {
        return routeRepository.findByName(name);
    }


}

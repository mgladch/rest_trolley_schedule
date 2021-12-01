package com.hladchuk.service;

import com.hladchuk.model.Route;

import java.util.List;

public interface RouteService extends AbstractDomainObjectService<Route>{
    List<Route> findAllByNumber(int number);
    Route findByName(String name);
}

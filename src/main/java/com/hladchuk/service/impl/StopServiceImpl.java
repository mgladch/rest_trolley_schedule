package com.hladchuk.service.impl;

import com.hladchuk.model.Stop;
import com.hladchuk.service.StopService;
import com.hladchuk.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopServiceImpl implements StopService {
    StopRepository stopRepository;

    @Autowired
    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public Stop save(Stop object) {
        return stopRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        stopRepository.deleteById(id);
    }

    @Override
    public Optional<Stop> findById(Integer id) {
        return stopRepository.findById(id);
    }

    @Override
    public List<Stop> findAll() {
        return stopRepository.findAll();
    }

    @Override
    public Stop findByName(String name) {
        return stopRepository.findByName(name);
    }

}

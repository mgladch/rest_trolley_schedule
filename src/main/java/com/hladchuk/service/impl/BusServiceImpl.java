package com.hladchuk.service.impl;

import com.hladchuk.model.transport.Bus;
import com.hladchuk.repository.BusRepository;
import com.hladchuk.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    BusRepository busRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public void removeById(Integer id) {
        busRepository.deleteById(id);
    }

    @Override
    public Optional<Bus> findById(Integer id) {
        return busRepository.findById(id);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }
}

package com.hladchuk.service.impl;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.service.PublicTransportService;
import com.hladchuk.repository.PublicTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicTransportServiceImpl implements PublicTransportService {
    PublicTransportRepository publicTransportRepository;

    @Autowired
    public PublicTransportServiceImpl(PublicTransportRepository publicTransportRepository) {
        this.publicTransportRepository = publicTransportRepository;
    }

    @Override
    public PublicTransport save(PublicTransport object) {
        return publicTransportRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        publicTransportRepository.deleteById(id);
    }

    @Override
    public Optional<PublicTransport> findById(Integer id) {
        return publicTransportRepository.findById(id);
    }

    @Override
    public List<PublicTransport> findAll() {
        return publicTransportRepository.findAll();
    }

    public List<PublicTransport> searchByType(String type) {
        return publicTransportRepository.searchByType(type);
    }

    @Override
    public List<PublicTransport> findPublicTransportByType(String type) {
        return publicTransportRepository.findPublicTransportByType(type);
    }


}

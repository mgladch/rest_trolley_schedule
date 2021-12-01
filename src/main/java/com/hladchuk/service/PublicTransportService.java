package com.hladchuk.service;

import com.hladchuk.model.PublicTransport;

import java.util.List;

public interface PublicTransportService extends AbstractDomainObjectService<PublicTransport>{
    List<PublicTransport> searchByType(String type);
    List<PublicTransport> findPublicTransportByType(String type);
}

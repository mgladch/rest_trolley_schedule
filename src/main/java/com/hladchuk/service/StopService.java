package com.hladchuk.service;

import com.hladchuk.model.Stop;

public interface StopService extends AbstractDomainObjectService<Stop>{
    Stop findByName(String name);
}

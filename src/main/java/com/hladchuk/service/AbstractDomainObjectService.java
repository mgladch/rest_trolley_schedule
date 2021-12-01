package com.hladchuk.service;

import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AbstractDomainObjectService <T>{
    public T save(@NonNull T object);

    public void removeById(@NonNull Integer id);

    public Optional<T> findById(@NonNull Integer id);

    public @NonNull
    List<T> findAll();
}

package com.hladchuk.repository;

import com.hladchuk.model.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicTransportRepository extends JpaRepository<PublicTransport, Integer> {

    @Query("select t from PublicTransport t where t.type=?1")
    List<PublicTransport> searchByType(String type);
    List<PublicTransport> findPublicTransportByType(String type);

}

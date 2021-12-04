package com.hladchuk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.model.Route;
import com.hladchuk.model.Schedule;
import com.hladchuk.repository.PublicTransportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicTransportServiceTest {

    public static final int ID = 1;
    public static final String TYPE = "little bus";
    public static final Route route = new Route();
    public static final Schedule schedule = new Schedule();
    public static final PublicTransport transport = new PublicTransport(ID,TYPE,70,34,route,schedule);

    @Autowired
    private PublicTransportService service;

    @MockBean
    private PublicTransportRepository repository;

    @Test
    public void shouldCreatePublicTransport(){
        when(repository.save(transport)).thenReturn(transport);

        assertEquals(transport, service.save(transport));
    }

    @Test
    public void shouldFindPublicTransportById(){
        when(repository.findById(ID)).thenReturn(Optional.of(transport));

        assertEquals(service.findById(ID), Optional.of(transport));
    }

    @Test
    public void shouldFindPublictransportByType(){
        when(repository.findPublicTransportByType(TYPE)).thenReturn(Stream.of(transport).collect(Collectors.toList()));

        assertEquals(1, service.findPublicTransportByType(TYPE).size());
    }

    @Test
    public void shouldAllFindPublictransport(){
        when(repository.findAll()).thenReturn(Stream.of(transport).collect(Collectors.toList()));

        assertEquals(1, service.findAll().size());
    }

    @Test
    public void shouldDeletePublicTransportById(){
        service.removeById(ID);
        PublicTransport transport1 = null;
        Optional<PublicTransport> opt = service.findById(ID);
        if(opt.isPresent())
            transport1 = opt.get();

        assertThat(transport1).isNull();
    }
}

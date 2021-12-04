package com.hladchuk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.model.Route;
import com.hladchuk.model.Stop;
import com.hladchuk.repository.RouteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouteServiceTest {

    public static final int ID = 1;
    public static final int NUMBER = 1;
    public static final PublicTransport transport = new PublicTransport();
    public static final Set<Stop> stops = new TreeSet<>();
    public static final Route route = new Route(ID,NUMBER,"","monday",transport,stops);

    @Autowired
    private RouteService service;

    @MockBean
    private RouteRepository repository;

    @Test
    public void shouldCreateRoute(){
        when(repository.save(route)).thenReturn(route);

        assertEquals(route, service.save(route));
    }

    @Test
    public void shouldFindById(){
        when(repository.findById(ID)).thenReturn(Optional.of(route));

        assertEquals(Optional.of(route), service.findById(ID));
    }

    @Test
    public void shouldFindRouteByNumber(){
        when(repository.findAllByNumber(NUMBER)).thenReturn(Stream.of(route).collect(Collectors.toList()));

        assertEquals(1, service.findAllByNumber(NUMBER).size());
    }

    @Test
    public void shouldFindAllRoutes(){
        when(repository.findAll()).thenReturn(Stream.of(route).collect(Collectors.toList()));

        assertEquals(1, service.findAll().size());
    }

    @Test
    public void shouldDeleteRouteById(){
        service.removeById(ID);
        Route route1 = null;
        Optional<Route> opt = service.findById(ID);
        if(opt.isPresent())
            route1 = opt.get();

        assertThat(route1).isNull();
    }
}

package com.hladchuk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.hladchuk.model.Route;
import com.hladchuk.model.Schedule;
import com.hladchuk.model.Stop;
import com.hladchuk.repository.StopRepository;
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
public class StopServiceTest {

    public static final Set<Route> route = new TreeSet();
    public static final Set<Schedule> schedules = new TreeSet();
    public static final int ID = 1;
    public static final String NAME ="Lukasha";
    public static final Stop stop = new Stop(ID,NAME,route,schedules);

    @Autowired
    private StopService service;

    @MockBean
    private StopRepository repository;

    @Test
    public void shouldCreateStop(){
        when(repository.save(stop)).thenReturn(stop);

        assertEquals(stop, service.save(stop));
    }

    @Test
    public void shouldFindStopById(){
        when(repository.findById(ID)).thenReturn(Optional.of(stop));

        assertThat(service.findById(ID)).isEqualTo(Optional.of(stop));
    }

    @Test
    public void shouldFindStopByName(){
        when(repository.findByName(NAME)).thenReturn(stop);

        assertThat(service.findByName(NAME)).isEqualTo(stop);
    }

    @Test
    public void shouldFindAllStops(){
        when(repository.findAll()).thenReturn(Stream.of(stop).collect(Collectors.toList()));

        assertEquals(1, service.findAll().size());
    }

    @Test
    public void shouldDeleteStopById(){
        service.removeById(ID);
        Stop stop_1 = null;
        Optional<Stop> optionalStop = service.findById(ID);
        if(optionalStop.isPresent())
            stop_1 = optionalStop.get();

        assertThat(stop_1).isNull();
    }
}

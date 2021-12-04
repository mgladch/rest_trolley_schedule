package com.hladchuk.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import com.hladchuk.model.transport.Bus;
import com.hladchuk.repository.BusRepository;
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
public class BusServiceTest {

    private static final Bus bus = new Bus(10, "bigBus", 25.5, 30);
    private static final Bus bus2 = new Bus(11, "smallBus", 29, 15);
    public static final int ID = 10;

    @Autowired
    private BusService service;

    @MockBean
    private BusRepository repository;

    @Test
    public void shouldCreateBus() {
        when(repository.save(bus)).thenReturn(bus);

        assertEquals(bus, service.save(bus));
    }

    @Test
    public void shouldFindBusById(){
        when(repository.findById(ID)).thenReturn(Optional.of(bus));

        assertThat(service.findById(ID)).isEqualTo(Optional.of(bus));
    }

    @Test
    public void shouldFindAllBuses() {
        when(repository.findAll()).thenReturn(Stream.of(bus, bus2).collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());
    }

    @Test
    public void shouldDeleteBusById(){
        service.removeById(ID);
        Bus buss = null;
        Optional<Bus> optionalBus = service.findById(ID);
        if(optionalBus.isPresent())
            buss = optionalBus.get();

        assertThat(buss).isNull();
    }

}

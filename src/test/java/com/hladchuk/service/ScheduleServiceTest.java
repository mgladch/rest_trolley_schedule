package com.hladchuk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.model.Schedule;
import com.hladchuk.model.Stop;
import com.hladchuk.repository.ScheduleRepository;
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
public class ScheduleServiceTest {

    public static final int ID = 1;
    public static final PublicTransport p = new PublicTransport();
    public static final Set<Stop> stops = new TreeSet<>();
    public static final Schedule schedule = new Schedule(ID,"13:00",p,stops);

    @Autowired
    private ScheduleService service;

    @MockBean
    private ScheduleRepository repository;

    @Test
    public void shouldCreateSchedule(){
        when(repository.save(schedule)).thenReturn(schedule);

        assertEquals(schedule, service.save(schedule));
    }

    @Test
    public void shouldFindScheduleById(){
        when(repository.findById(ID)).thenReturn(Optional.of(schedule));

        assertEquals(Optional.of(schedule), service.findById(ID));
    }

    @Test
    public void shouldFindAllSchedules(){
        when(repository.findAll()).thenReturn(Stream.of(schedule).collect(Collectors.toList()));

        assertEquals(1, service.findAll().size());
    }

    @Test
    public void shouldDeleteScheduleById(){
        service.removeById(ID);
        Schedule schedule1 = null;
        Optional<Schedule> opt = service.findById(ID);
        if(opt.isPresent())
            schedule1 = opt.get();

        assertThat(schedule1).isNull();
    }

}

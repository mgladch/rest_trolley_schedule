package com.hladchuk.mapper;

import com.hladchuk.model.Schedule;
import com.hladchuk.model.dto.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleDto toDto(Schedule schedule);

    Schedule toSchedule(ScheduleDto scheduleDto);

    List<ScheduleDto> scheduleToScheduleDtos(List<Schedule> schedules);
    Set<ScheduleDto> scheduleToScheduleDtosSet(List<Schedule> routes);


    List<Schedule> scheduleDtoToSchedules(List<ScheduleDto> scheduleDtos);
}

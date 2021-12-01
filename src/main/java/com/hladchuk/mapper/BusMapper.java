package com.hladchuk.mapper;

import com.hladchuk.model.transport.Bus;
import com.hladchuk.model.dto.BusDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);

    BusDto toDto(Bus bus);

    Bus toBus(BusDto busDto);

    List<BusDto> busToBusDtos(List<Bus> buses);

    List<Bus> busDtoToBuses(List<BusDto> busDtos);
}

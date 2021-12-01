package com.hladchuk.mapper.postmapper;

import com.hladchuk.model.Stop;
import com.hladchuk.model.dto.postdto.PostStopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface PostStopMapper {
    PostStopMapper INSTANCE = Mappers.getMapper(PostStopMapper.class);

    PostStopDto toPostDto(Stop stop);

    Stop postDtoToStop(PostStopDto postStopDto);

    List<PostStopDto> stopToPostStopDtos(List<Stop> stops);

    Set<PostStopDto> stopToPostStopDtosSet(List<Stop> stops);

    List<Stop> stopPostDtoToStops(List<PostStopDto> stopDtos);

}

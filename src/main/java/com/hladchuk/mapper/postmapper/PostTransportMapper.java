package com.hladchuk.mapper.postmapper;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.model.dto.postdto.PostTransportDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostTransportMapper {
    PostTransportMapper INSTANCE = Mappers.getMapper(PostTransportMapper.class);

    PostTransportDto toDto(PublicTransport publicTransport);

    PublicTransport postDtoToPublicTransport(PostTransportDto postTransportDto);

    List<PostTransportDto> transportToPostTransportDtos(List<PublicTransport> transports);

    List<PublicTransport> postTransportDtoToTransports(List<PostTransportDto> postTransportDtos);
}

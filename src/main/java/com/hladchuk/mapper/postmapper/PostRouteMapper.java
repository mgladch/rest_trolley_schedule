package com.hladchuk.mapper.postmapper;

import com.hladchuk.model.Route;
import com.hladchuk.model.dto.postdto.PostRouteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface PostRouteMapper {
    PostRouteMapper INSTANCE = Mappers.getMapper(PostRouteMapper.class);

    PostRouteDto toPostDto(Route route);

    Route postDtoToRoute(PostRouteDto postRouteDto);

    List<PostRouteDto> routeToPostRouteDtos(List<Route> routes);

    Set<PostRouteDto> routeToPostRouteDtosSet(List<Route> routes);

    List<Route> postRouteDtoToRoutes(List<PostRouteDto> routeDtos);
}

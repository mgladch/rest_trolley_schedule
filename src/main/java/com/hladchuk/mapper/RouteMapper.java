package com.hladchuk.mapper;

import com.hladchuk.model.Route;
import com.hladchuk.model.dto.RouteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDto toDto(Route route);

    Route toRoute(RouteDto routeDto);

    List<RouteDto> routeToRouteDtos(List<Route> routes);
    Set<RouteDto>routeToRouteDtosSet(List<Route> routes);

    List<Route> routeDtoToRoutes(List<RouteDto> routeDtos);
}

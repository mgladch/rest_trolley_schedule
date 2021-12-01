
package com.hladchuk.util;

import com.hladchuk.mapper.StopMapper;
import com.hladchuk.model.dto.StopDto;
import com.hladchuk.service.StopService;
import com.hladchuk.model.dto.RouteDto;
import com.hladchuk.model.dto.postdto.PostRouteDto;
import com.hladchuk.model.dto.postdto.PostTransportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StopUtil {
    StopService stopService;

    @Autowired
    public StopUtil(StopService stopService) {
        this.stopService = stopService;
    }

    //у яких маршрутах є ця зупинка
    public Set<PostRouteDto> getRoutesByStopName(String stopName) {
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoSet = new HashSet<>();
        routeDtoSet = stopDto.getRoutes();
        Set<PostRouteDto> postRouteDtoSet = new HashSet<>();
        for (RouteDto routeDto : routeDtoSet) {
            postRouteDtoSet.add(new PostRouteDto(routeDto.getId(), routeDto.getNumber(), routeDto.getName(), routeDto.getDays(), routeDto.getPublicTransport()));
        }
        return postRouteDtoSet;
    }
    //який транспорт тут їздить
    public Set<PostTransportDto> getTransportByStopName(String stopName){
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoList = stopDto.getRoutes();
        Set<PostTransportDto> transportsDtoSet = new HashSet<>();
        for (RouteDto routeDto:routeDtoList){
            transportsDtoSet.add(routeDto.getPublicTransport());
        }
        return transportsDtoSet;
    }
}

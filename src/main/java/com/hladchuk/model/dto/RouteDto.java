package com.hladchuk.model.dto;

import com.hladchuk.model.dto.postdto.PostStopDto;
import com.hladchuk.model.dto.postdto.PostTransportDto;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RouteDto {
    private int id;
    private int number;
    private String name;
    private String days;
    private PostTransportDto publicTransport;
    private Set<PostStopDto> stops = new HashSet<>();
}

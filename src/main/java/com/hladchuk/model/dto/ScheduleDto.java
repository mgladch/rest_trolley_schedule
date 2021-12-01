package com.hladchuk.model.dto;

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
public class ScheduleDto {
    private int id;
    private String hours;
    private Set<StopDto> stops = new HashSet<>();
    private PostTransportDto publicTransport;
}

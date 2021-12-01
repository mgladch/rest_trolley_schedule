package com.hladchuk.model.dto.postdto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostStopDto {
    private int id;
    private String name;
    private Set<PostScheduleDto> schedules = new HashSet<>();
}

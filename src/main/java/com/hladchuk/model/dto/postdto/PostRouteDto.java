package com.hladchuk.model.dto.postdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostRouteDto {
    private int id;
    private int number;
    private String name;
    private String days;
    private PostTransportDto publicTransport;
}

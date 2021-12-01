package com.hladchuk.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PublicTransportDto {
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
    private RouteDto route;
    private ScheduleDto scheduleDto;
}

package com.hladchuk.model.dto.postdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostTransportDto {
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
}

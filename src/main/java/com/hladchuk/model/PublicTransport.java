package com.hladchuk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"route","schedule"})
@Table(name = "publicTransport_tb")
public class PublicTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "publicTransport")
    private Route route;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "publicTransport")
    private Schedule schedule;

}

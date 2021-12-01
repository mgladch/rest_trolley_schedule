package com.hladchuk.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"publicTransport","stops"})
@Table(name = "route_tb")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String name;
    private String days;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicTransport_id", referencedColumnName = "id")
    private PublicTransport publicTransport;

    @ManyToMany
    @JoinTable(name = "stop_route", joinColumns = {@JoinColumn(name = "route_id")}, inverseJoinColumns = {@JoinColumn(name = "stop_id")})
    @JsonManagedReference
    private Set<Stop> stops = new HashSet<>();
}

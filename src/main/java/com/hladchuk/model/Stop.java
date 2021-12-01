package com.hladchuk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(exclude={"routes","schedules"})
@Table(name = "stop_tb")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "stops")
    @JsonBackReference
    private Set<Route> routes = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "schedule_stop", joinColumns = {@JoinColumn(name = "stop_id")}, inverseJoinColumns = {@JoinColumn(name = "schedule_id")})
    private Set<Schedule> schedules = new HashSet<>();
}

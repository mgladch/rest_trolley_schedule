package com.hladchuk.model;

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
@Table(name = "schedule_tb")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hours;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicTransport_id", referencedColumnName = "id")
    private PublicTransport publicTransport;


    @ManyToMany(mappedBy = "schedules")
    private Set<Stop> stops = new HashSet<>();
}

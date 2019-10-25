package com.zmp.cinema.seats.reservation.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "CinemaHall")
public class CinemaHall {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cinemaHallNumber")
    private Integer cinemaHallNumber;

    @OneToOne(mappedBy = "cinemaHall")
    private Seance seance;

    @OneToMany(mappedBy = "cinemaHall")
    private List<Seat> seats;
}

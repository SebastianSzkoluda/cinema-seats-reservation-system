package com.zmp.cinema.seats.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "CinemaHall")
public class CinemaHall {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cinemaHallNumber")
    private Integer cinemaHallNumber;

    @Column(name = "cinemaHallName")
    private String cinemaHallName;

    @OneToOne(mappedBy = "cinemaHall")
    private Seance seance;

    @OneToMany(mappedBy = "cinemaHall", cascade=CascadeType.ALL)
    private List<Seat> seats;
}

package com.zmp.cinema.seats.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
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

    @Column(name = "cinemaHallNumber", columnDefinition = "integer auto_increment")
    private Integer cinemaHallNumber;

    @Column(name = "cinemaHallName")
    private String cinemaHallName;

    @Column(name = "createdAt")
    private Instant createdAt;

    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
    private List<Seance> seances;

    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
    private List<Seat> seats;
}

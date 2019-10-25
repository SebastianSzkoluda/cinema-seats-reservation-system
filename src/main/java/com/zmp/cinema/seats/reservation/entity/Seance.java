package com.zmp.cinema.seats.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Seance")
public class Seance {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="filmName")
    private String filmName;

    @Column(name="showingTime")
    private LocalDate showingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinemaHall_id", referencedColumnName = "id", nullable = false)
    private CinemaHall cinemaHall;
}

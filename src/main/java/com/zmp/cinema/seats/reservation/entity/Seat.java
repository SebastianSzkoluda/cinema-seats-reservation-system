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
@Builder
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatXPosition")
    private String seatXPosition;

    @Column(name = "seatYPosition")
    private String seatYPosition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinemaHall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "SeatReservations",
            joinColumns = {@JoinColumn(name = "seat_id")},
            inverseJoinColumns = {@JoinColumn(name = "reservation_id")}
    )
    private List<Reservation> reservation;
}

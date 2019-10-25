package com.zmp.cinema.seats.reservation.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatXPosition")
    private String seatXPosition;

    @Column(name = "seatYPosition")
    private String seatYPosition;

    @ManyToOne
    @JoinColumn(name="cinemaHall_id", referencedColumnName = "id", nullable=false)
    private CinemaHall cinemaHall;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public boolean isTaken() {
        return user != null;
    }
}

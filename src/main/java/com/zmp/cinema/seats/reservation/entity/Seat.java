package com.zmp.cinema.seats.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cinemaHall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public boolean isTaken() {
        return user != null;
    }
}

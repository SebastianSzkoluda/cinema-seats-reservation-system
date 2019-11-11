package com.zmp.cinema.seats.reservation.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"filmName", "showingTime", "cinemaHall"})
@Builder
@Entity
@Table(name = "Seance")
public class Seance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filmName")
    private String filmName;

    //2019-10-28T16:00:49.455 - format
    @Column(name = "showingTime")
    private LocalDateTime showingTime;

    //in minutes
    @Column(name = "filmDuration")
    private Integer filmDuration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinemaHall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "seance", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}

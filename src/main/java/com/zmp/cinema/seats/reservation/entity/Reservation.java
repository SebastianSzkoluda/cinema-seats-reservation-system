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
@Table(name = "Reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_id", referencedColumnName = "id")
    private Seance seance;

    @ManyToMany(mappedBy = "reservation")
    private List<Seat> seats;
}

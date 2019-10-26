package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.entity.Reservation;

import java.util.Optional;

public interface ReservationService {

    boolean saveReservation(Reservation reservation);

    Optional<Reservation> findById(Long id);
}

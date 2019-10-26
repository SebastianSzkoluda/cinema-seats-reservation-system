package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.entity.Seat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SeatService {

    Optional<Seat> findById(Long id);

    List<Seat> findByIdIn(Set<Long> id);

    boolean saveSeat(Seat seat);

    boolean saveSeats(List<Seat> seats);
}

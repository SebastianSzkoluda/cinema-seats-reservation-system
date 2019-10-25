package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}

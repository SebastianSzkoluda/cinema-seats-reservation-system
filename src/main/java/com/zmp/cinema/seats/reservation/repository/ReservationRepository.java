package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Optional<Reservation> findById(Long id);
}

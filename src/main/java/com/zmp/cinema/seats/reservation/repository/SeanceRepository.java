package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seance;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeanceRepository extends CrudRepository<Seance, Long> {

    Optional<Seance> findById(Long id);
}

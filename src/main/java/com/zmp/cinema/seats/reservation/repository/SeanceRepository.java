package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.Seance;
import org.springframework.data.repository.CrudRepository;

public interface SeanceRepository extends CrudRepository<Seance, Long> {
}

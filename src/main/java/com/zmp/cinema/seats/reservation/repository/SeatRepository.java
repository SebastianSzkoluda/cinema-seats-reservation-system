package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    Optional<Seat> findById(Long id);

    List<Seat> findByIdIn(Set<Long> ids);
}

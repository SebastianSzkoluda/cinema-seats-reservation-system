package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaHallRepository extends CrudRepository<CinemaHall, Long> {

    Optional<CinemaHall> findFirstByOrderByCreatedAtDesc();

    List<CinemaHall> findByCinemaHallName(String cinemaHallName);

    Optional<CinemaHall> findById(Long id);
}

package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface CinemaHallService {

    Optional<CinemaHall> readCinemaHallFromFile(InputStream resource) throws IOException;

    boolean saveCinemaHall(CinemaHall cinemaHall);

    Optional<CinemaHall> loadCinemaHall(Long id);

    List<CinemaHall> loadCinemaHalls();

    Optional<CinemaHall> loadLatestReadCinemaHall();
}

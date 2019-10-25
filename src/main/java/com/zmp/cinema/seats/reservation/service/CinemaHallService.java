package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public interface CinemaHallService {

    CinemaHall readCinemaHallFromFile(File file) throws IOException;

    boolean saveCinemaHall(CinemaHall cinemaHall);

    Optional<CinemaHall> findById(long id);
}

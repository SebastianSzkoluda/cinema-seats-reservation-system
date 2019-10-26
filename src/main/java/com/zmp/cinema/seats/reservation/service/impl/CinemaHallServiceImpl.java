package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.repository.CinemaHallRepository;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public CinemaHall readCinemaHallFromFile(File file) throws IOException {
        CinemaHall cinemaHall = CinemaHall.builder().build();
        Scanner scanner = new Scanner(file);
        cinemaHall.setCinemaHallName(scanner.nextLine());
        List<Seat> seats = Files.lines(file.toPath())
                .skip(1)
                .map(s -> Arrays.stream(s.replaceAll("\\s+", "").split("\\|"))
                        .skip(1)
                        .map(s1 -> Seat.builder()
                                .cinemaHall(cinemaHall)
                                .seatXPosition(s1)
                                .seatYPosition(s.substring(0, 1))
                                .build())
                        .collect(Collectors.toList())
                ).flatMap(Collection::stream)
                .collect(Collectors.toList());
        cinemaHall.setSeats(seats);
        return cinemaHall;
    }

    @Override
    public boolean saveCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall) != null;
    }

    @Override
    public Optional<CinemaHall> findById(Long id) {
        return cinemaHallRepository.findById(id);
    }
}

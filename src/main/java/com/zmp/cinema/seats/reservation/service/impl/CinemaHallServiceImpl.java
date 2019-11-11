package com.zmp.cinema.seats.reservation.service.impl;

import com.google.common.collect.ImmutableList;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.repository.CinemaHallRepository;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public CinemaHall readCinemaHallFromFile(InputStream resource) throws IOException {
        CinemaHall cinemaHall = CinemaHall.builder().build();
        List<String> lines = IOUtils.readLines(resource, StandardCharsets.UTF_8);
        cinemaHall.setCinemaHallName(lines.get(0));
        cinemaHall.setCreatedAt(Instant.now());
        List<Seat> seats = lines.stream()
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
    public Optional<CinemaHall> loadCinemaHall(Long id) {
        return cinemaHallRepository.findById(id);
    }

    @Override
    public List<CinemaHall> loadCinemaHalls() {
        return ImmutableList.copyOf(cinemaHallRepository.findAll());
    }

    @Override
    public Optional<CinemaHall> loadLatestReadCinemaHall() {
        return cinemaHallRepository.findFirstByOrderByCreatedAtDesc();
    }
}

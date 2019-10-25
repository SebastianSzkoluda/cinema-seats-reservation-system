package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.repository.CinemaHallRepository;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
        List<Seat> seats = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        cinemaHall.setCinemaHallName(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> cinemaHallRow = Arrays.asList(line.split("\\|"));
            for (String ch : cinemaHallRow) {
                Seat.SeatBuilder builder = Seat.builder();
                if (cinemaHallRow.indexOf(ch) != 0) {
                    builder.seatYPosition(cinemaHallRow.get(0));
                    builder.seatXPosition(ch);
                    builder.cinemaHall(cinemaHall);
                    Seat seat = builder.build();
                    seats.add(seat);
                }
            }
        }
        cinemaHall.setCinemaHallNumber(1);
        cinemaHall.setSeats(seats);
        return cinemaHall;
    }

    @Override
    public boolean saveCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall) != null;
    }

    @Override
    public Optional<CinemaHall> findById(long id) {
        return cinemaHallRepository.findById(id);
    }
}

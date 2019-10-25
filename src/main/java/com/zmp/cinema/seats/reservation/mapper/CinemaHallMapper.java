package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.CinemaHallDto;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;

import java.util.stream.Collectors;

public class CinemaHallMapper {

    public static CinemaHallDto mapCinemaHallToCinemaHallDto(CinemaHall cinemaHall) {
        return CinemaHallDto.builder()
                .id(cinemaHall.getId())
                .cinemaHallName(cinemaHall.getCinemaHallName())
                .cinemaHallNumber(cinemaHall.getCinemaHallNumber())
                .seats(cinemaHall.getSeats().stream().map(SeatMapper::mapSeatToSeatDto).collect(Collectors.toList()))
                .build();
    }
}

package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.CinemaHallDto;
import com.zmp.cinema.seats.reservation.dto.CinemaHallOptionDto;
import com.zmp.cinema.seats.reservation.dto.SeatDto;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;

import java.util.Collection;
import java.util.stream.Collectors;

public class CinemaHallMapper {

    public static CinemaHallDto mapCinemaHallToCinemaHallDto(CinemaHall cinemaHall) {
        return CinemaHallDto.builder()
                .id(cinemaHall.getId())
                .cinemaHallName(cinemaHall.getCinemaHallName())
                .cinemaHallNumber(cinemaHall.getCinemaHallNumber())
                .createdAt(cinemaHall.getCreatedAt())
                .seats(cinemaHall.getSeats().stream()
                        .map(SeatMapper::mapSeatToSeatDto)
                        .collect(Collectors.groupingBy(SeatDto::getSeatYPosition)))
                .build();
    }

    public static CinemaHall mapCinemaHallDtoToCinemaHall(CinemaHallDto cinemaHallDto) {
        return CinemaHall.builder()
                .id(cinemaHallDto.getId())
                .cinemaHallName(cinemaHallDto.getCinemaHallName())
                .cinemaHallNumber(cinemaHallDto.getCinemaHallNumber())
                .createdAt(cinemaHallDto.getCreatedAt())
                .seats(cinemaHallDto.getSeats().values().stream()
                        .flatMap(Collection::stream)
                        .map(SeatMapper::mapSeatDtoToSeat)
                        .collect(Collectors.toList()))
                .build();
    }

    public static CinemaHallOptionDto mapCinemaHallToCinemaHallOptionDto(CinemaHall cinemaHall) {
        return CinemaHallOptionDto.builder()
                .id(cinemaHall.getId())
                .cinemaHallName(cinemaHall.getCinemaHallName())
                .build();
    }
}

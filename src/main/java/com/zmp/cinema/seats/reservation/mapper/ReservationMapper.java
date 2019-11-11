package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.ReservationDto;
import com.zmp.cinema.seats.reservation.entity.Reservation;

import java.util.stream.Collectors;

public class ReservationMapper {

    public static ReservationDto mapReservationToReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .firstName(reservation.getFirstName())
                .lastName(reservation.getLastName())
                .seance(SeanceMapper.mapSeanceToSeanceDto(reservation.getSeance()))
                .seats(reservation.getSeats().stream().map(SeatMapper::mapSeatToSeatDto).collect(Collectors.toList()))
                .build();
    }

    public static Reservation mapReservationDtoToReservation(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .firstName(reservationDto.getFirstName())
                .lastName(reservationDto.getLastName())
                .seance(SeanceMapper.mapSeanceDtoToSeance(reservationDto.getSeance()))
                .seats(reservationDto.getSeats().stream().map(SeatMapper::mapSeatDtoToSeat).collect(Collectors.toList()))
                .build();
    }
}

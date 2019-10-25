package com.zmp.cinema.seats.reservation.dto;

import lombok.Value;

import java.util.List;

@Value
public class CinemaHallDto {

    Long id;

    Integer cinemaHalNumber;

    List<SeatDto> seatDtos;

    CinemaDto cinema;
}

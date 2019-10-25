package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class CinemaHallDto {

    Long id;

    Integer cinemaHallNumber;

    String cinemaHallName;

    List<SeatDto> seats;
}

package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Builder
@Value
public class CinemaHallDto {

    Long id;

    Integer cinemaHallNumber;

    String cinemaHallName;

    Instant createdAt;

    Map<String, List<SeatDto>> seats;
}

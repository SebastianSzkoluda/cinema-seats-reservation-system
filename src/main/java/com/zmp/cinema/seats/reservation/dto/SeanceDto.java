package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class SeanceDto {

    Long id;

    String filmName;

    LocalDateTime showingTime;

    Integer filmDuration;

    CinemaHallDto cinemaHall;
}

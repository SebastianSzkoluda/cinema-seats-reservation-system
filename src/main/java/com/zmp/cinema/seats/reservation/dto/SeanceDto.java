package com.zmp.cinema.seats.reservation.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class SeanceDto {

    Long id;

    String filmName;

    LocalDate showingTime;

    CinemaHallDto cinemaHall;
}

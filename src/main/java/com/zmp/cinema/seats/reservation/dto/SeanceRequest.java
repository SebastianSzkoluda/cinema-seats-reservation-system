package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Builder
@Value
public class SeanceRequest {

    Long id;

    String filmName;

    LocalDate showingTime;

    Integer filmDuration;

    Long cinemaHallId;
}

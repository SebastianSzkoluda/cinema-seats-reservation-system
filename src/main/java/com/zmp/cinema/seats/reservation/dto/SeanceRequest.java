package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class SeanceRequest {

    String filmName;

    LocalDateTime showingTime;

    Integer filmDuration;

    Long cinemaHallId;
}

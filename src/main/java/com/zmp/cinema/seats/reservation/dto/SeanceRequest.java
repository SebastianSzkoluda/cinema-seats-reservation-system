package com.zmp.cinema.seats.reservation.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Value
public class SeanceRequest {

    @NotNull
    String filmName;

    @NotNull
    LocalDateTime showingTime;

    @NotNull
    Integer filmDuration;

    @NotNull
    Long cinemaHallId;
}

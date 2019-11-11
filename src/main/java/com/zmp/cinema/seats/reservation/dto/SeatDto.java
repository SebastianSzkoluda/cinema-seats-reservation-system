package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class SeatDto {

    Long id;

    @NotNull
    String seatXPosition;

    @NotNull
    String seatYPosition;
}

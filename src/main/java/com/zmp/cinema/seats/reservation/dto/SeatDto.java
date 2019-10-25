package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class SeatDto {

    Long id;

    String seatXPosition;

    String seatYPosition;

    Boolean isTaken;
}

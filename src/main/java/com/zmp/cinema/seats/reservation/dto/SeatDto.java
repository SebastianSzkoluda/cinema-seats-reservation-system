package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.Optional;

@Builder
@Value
public class SeatDto {

    Long id;

    String seatXPosition;

    String seatYPosition;

    String user;

    public Optional<String> getUser() {
        return Optional.ofNullable(user);
    }
}

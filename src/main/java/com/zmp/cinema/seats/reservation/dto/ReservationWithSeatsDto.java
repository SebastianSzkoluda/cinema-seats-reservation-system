package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ReservationWithSeatsDto {

    Long id;

    String firstName;

    String lastName;

    List<SeatDto> seats;
}

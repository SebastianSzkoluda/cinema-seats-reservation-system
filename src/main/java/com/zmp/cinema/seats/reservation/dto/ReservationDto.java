package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ReservationDto {

    Long id;

    SeanceDto seance;

    String firstName;

    String lastName;

    List<SeatDto> seats;
}

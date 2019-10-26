package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ReservationDto {

    Long id;

    SeanceDto seance;

    CustomerDto customer;

    List<SeatDto> seats;
}

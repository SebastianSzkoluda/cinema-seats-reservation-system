package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Builder
@Value
public class ReservationRequest {

    Long seanceId;

    String firstName;

    String lastName;

    Set<Long> seatIds;
}

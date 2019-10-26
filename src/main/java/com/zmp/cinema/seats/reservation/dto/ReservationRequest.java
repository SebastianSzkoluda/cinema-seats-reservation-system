package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Builder
@Value
public class ReservationRequest {

    Long seanceId;

    CustomerDto customer;

    Set<Long> seatIds;
}

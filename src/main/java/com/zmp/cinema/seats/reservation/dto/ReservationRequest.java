package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@Value
public class ReservationRequest {

    @NotNull
    Long seanceId;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    Set<Long> seatIds;
}

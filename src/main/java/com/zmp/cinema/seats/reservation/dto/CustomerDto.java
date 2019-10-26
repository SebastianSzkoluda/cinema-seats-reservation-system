package com.zmp.cinema.seats.reservation.dto;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CustomerDto {

    Long id;

    String firstName;

    String lastName;
}

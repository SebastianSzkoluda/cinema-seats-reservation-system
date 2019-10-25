package com.zmp.cinema.seats.reservation.dto;

import lombok.Value;

@Value
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private SeatDto seat;
}

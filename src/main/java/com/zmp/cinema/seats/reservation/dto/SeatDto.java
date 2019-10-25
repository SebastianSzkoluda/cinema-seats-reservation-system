package com.zmp.cinema.seats.reservation.dto;


import lombok.Value;

@Value
public class SeatDto {

    Long id;

    Integer seatNumber;

    CinemaHallDto cinemaHall;

    UserDto user;
}

package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.SeatDto;
import com.zmp.cinema.seats.reservation.entity.Seat;

public class SeatMapper {

    public static SeatDto mapSeatToSeatDto(Seat seat) {
        return SeatDto.builder()
                .id(seat.getId())
                .seatXPosition(seat.getSeatXPosition())
                .seatYPosition(seat.getSeatYPosition())
                .build();
    }

    public static Seat mapSeatDtoToSeat(SeatDto seatDto) {
        return Seat.builder()
                .id(seatDto.getId())
                .seatXPosition(seatDto.getSeatXPosition())
                .seatYPosition(seatDto.getSeatYPosition())
                .build();
    }
}

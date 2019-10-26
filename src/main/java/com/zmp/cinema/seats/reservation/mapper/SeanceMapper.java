package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.SeanceDto;
import com.zmp.cinema.seats.reservation.dto.SeanceRequest;
import com.zmp.cinema.seats.reservation.dto.SeatDto;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seance;
import com.zmp.cinema.seats.reservation.entity.Seat;

public class SeanceMapper {

    public static SeanceDto mapSeanceToSeanceDto(Seance seance) {
        return SeanceDto.builder()
                .id(seance.getId())
                .cinemaHall(CinemaHallMapper.mapCinemaHallToCinemaHallDto(seance.getCinemaHall()))
                .filmName(seance.getFilmName())
                .showingTime(seance.getShowingTime())
                .filmDuration(seance.getFilmDuration())
                .build();
    }

    public static Seance mapSeanceDtoToSeance(SeanceDto seanceDto) {
        return Seance.builder()
                .id(seanceDto.getId())
                .cinemaHall(CinemaHallMapper.mapCinemaHallDtoToCinemaHall(seanceDto.getCinemaHall()))
                .filmName(seanceDto.getFilmName())
                .showingTime(seanceDto.getShowingTime())
                .filmDuration(seanceDto.getFilmDuration())
                .build();
    }

    public static Seance mapSeanceRequestToSeance(SeanceRequest seanceRequest, CinemaHall cinemaHall) {
        return Seance.builder()
                .id(seanceRequest.getId())
                .cinemaHall(cinemaHall)
                .filmName(seanceRequest.getFilmName())
                .showingTime(seanceRequest.getShowingTime())
                .filmDuration(seanceRequest.getFilmDuration())
                .build();
    }
}

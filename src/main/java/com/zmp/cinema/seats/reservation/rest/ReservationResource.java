package com.zmp.cinema.seats.reservation.rest;

import com.zmp.cinema.seats.reservation.dto.ReservationDto;
import com.zmp.cinema.seats.reservation.dto.ReservationRequest;
import com.zmp.cinema.seats.reservation.entity.Reservation;
import com.zmp.cinema.seats.reservation.entity.Seance;
import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.mapper.ReservationMapper;
import com.zmp.cinema.seats.reservation.service.ReservationService;
import com.zmp.cinema.seats.reservation.service.SeanceService;
import com.zmp.cinema.seats.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/reservation")
public class ReservationResource {

    private final ReservationService reservationService;
    private final SeanceService seanceService;
    private final SeatService seatService;

    @Autowired
    public ReservationResource(ReservationService reservationService, SeanceService seanceService, SeatService seatService) {
        this.reservationService = reservationService;
        this.seanceService = seanceService;
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<ReservationDto> addNewReservation(@RequestBody ReservationRequest reservationRequest) {
        Long seanceId = reservationRequest.getSeanceId();
        Set<Long> seatIds = reservationRequest.getSeatIds();

        Seance seance = seanceService.findById(seanceId).orElseThrow(IllegalArgumentException::new);
        List<Seat> seats = seatService.findByIdIn(seatIds);

        Reservation reservation = Reservation.builder().build();

        for (Seat seat : seats) {
            List<Reservation> reservations = Stream.concat(Stream.of(reservation), seat.getReservation().stream())
                    .collect(Collectors.toList());
            seat.setReservation(reservations);
        }
        reservation.setFirstName(reservationRequest.getFirstName());
        reservation.setLastName(reservationRequest.getLastName());
        reservation.setSeance(seance);
        reservation.setSeats(seats);
        if (reservationService.saveReservation(reservation)) {
            return ResponseEntity.ok(ReservationMapper.mapReservationToReservationDto(reservation));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

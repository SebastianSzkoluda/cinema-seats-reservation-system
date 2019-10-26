package com.zmp.cinema.seats.reservation.rest;

import com.zmp.cinema.seats.reservation.dto.ReservedSeatsDto;
import com.zmp.cinema.seats.reservation.dto.SeanceDto;
import com.zmp.cinema.seats.reservation.dto.SeanceRequest;
import com.zmp.cinema.seats.reservation.entity.Seance;
import com.zmp.cinema.seats.reservation.mapper.ReservationMapper;
import com.zmp.cinema.seats.reservation.mapper.SeanceMapper;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import com.zmp.cinema.seats.reservation.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/seance/")
public class SeanceResource {

    private final CinemaHallService cinemaHallService;
    private final SeanceService seanceService;

    @Autowired
    public SeanceResource(CinemaHallService cinemaHallService, SeanceService seanceService) {
        this.cinemaHallService = cinemaHallService;
        this.seanceService = seanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeanceDto> retrieveSeance(@PathVariable long id) {
        Optional<Seance> seance = seanceService.findById(id);

        if (!seance.isPresent()) {
            throw new RuntimeException("id-" + id);
        }

        return ResponseEntity.ok(seance.map(SeanceMapper::mapSeanceToSeanceDto).get());
    }

    @GetMapping("seats/{id}")
    public List<ReservedSeatsDto> getReservedSeatsForSeance(@PathVariable Long id) {
        return seanceService.findById(id)
                .map(seance -> seance.getReservations().stream()
                        .map(ReservationMapper::mapReservationToReservedSeatsDto)
                        .collect(Collectors.toList()))
                .orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping
    public ResponseEntity<SeanceDto> addSeance(@RequestBody SeanceRequest seanceRequest) {
        Seance seance = cinemaHallService.findById(seanceRequest.getCinemaHallId())
                .map(cinemaHall -> SeanceMapper.mapSeanceRequestToSeance(seanceRequest, cinemaHall))
                .orElseThrow(IllegalArgumentException::new);

        if (seanceService.saveSeance(seance)) {
            URI location = ServletUriComponentsBuilder.fromPath("/api/seance/{id}")
                    .buildAndExpand(seance.getId()).toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

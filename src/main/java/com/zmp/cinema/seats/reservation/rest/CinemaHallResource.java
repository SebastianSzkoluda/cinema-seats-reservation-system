package com.zmp.cinema.seats.reservation.rest;

import com.zmp.cinema.seats.reservation.dto.CinemaHallDto;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.mapper.CinemaHallMapper;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/api/cinema-hall")
public class CinemaHallResource {

    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallResource(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaHallDto> retrieveCinemaHall(@PathVariable Long id) {
        Optional<CinemaHall> cinemaHall = cinemaHallService.findById(id);

        if (!cinemaHall.isPresent()) {
            throw new RuntimeException("id-" + id);
        }

        return ResponseEntity.ok(cinemaHall.map(CinemaHallMapper::mapCinemaHallToCinemaHallDto).get());
    }

    @PostMapping("/file")
    public ResponseEntity<CinemaHallDto> readCinemaHallFromFile(@RequestParam File file) throws IOException {
        CinemaHall cinemaHall = cinemaHallService.readCinemaHallFromFile(file);
        if (cinemaHallService.saveCinemaHall(cinemaHall)) {
            URI location = ServletUriComponentsBuilder.fromPath("/api/cinema-hall/{id}")
                    .buildAndExpand(cinemaHall.getId()).toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/isTaken/{hallId}/{id}")
    public ResponseEntity<Boolean> isSeatTaken(@PathVariable Long hallId, @PathVariable Long id) {
        return cinemaHallService.findById(hallId)
                .map(cinemaHall -> ResponseEntity.ok(cinemaHall.getSeats().stream()
                        .filter(seat -> seat.getId().equals(id))
                        .findFirst()
                        .map(Seat::getUser)
                        .isPresent()
                ))
                .orElse(ResponseEntity.badRequest().build());
    }
}

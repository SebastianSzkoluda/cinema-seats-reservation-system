package com.zmp.cinema.seats.reservation.rest;

import com.zmp.cinema.seats.reservation.dto.CinemaHallDto;
import com.zmp.cinema.seats.reservation.dto.CinemaHallOptionDto;
import com.zmp.cinema.seats.reservation.entity.CinemaHall;
import com.zmp.cinema.seats.reservation.mapper.CinemaHallMapper;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cinema-hall")
public class CinemaHallResource {

    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallResource(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallOptionDto> getAllCinemaHalls() {
        return cinemaHallService.loadCinemaHalls().stream()
                .map(CinemaHallMapper::mapCinemaHallToCinemaHallOptionDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaHallDto> retrieveCinemaHall(@PathVariable Long id) {
        Optional<CinemaHall> cinemaHall = cinemaHallService.loadCinemaHall(id);

        if (!cinemaHall.isPresent()) {
            throw new RuntimeException("id-" + id);
        }

        return ResponseEntity.ok(cinemaHall.map(CinemaHallMapper::mapCinemaHallToCinemaHallDto).get());
    }

    @GetMapping("/latest")
    public List<CinemaHallDto> retrieveLatestCinemaHall() {
        Optional<CinemaHall> cinemaHall = cinemaHallService.loadLatestReadCinemaHall();

        if (!cinemaHall.isPresent()) {
            return Collections.emptyList();
        }

        return Collections.singletonList(cinemaHall.map(CinemaHallMapper::mapCinemaHallToCinemaHallDto).get());
    }

    @PostMapping("/file")
    public ResponseEntity<CinemaHallDto> readCinemaHallFromFile(@RequestParam MultipartFile file) throws IOException {
        CinemaHall cinemaHall = cinemaHallService.readCinemaHallFromFile(file.getInputStream());
        if (cinemaHallService.saveCinemaHall(cinemaHall)) {
            URI location = ServletUriComponentsBuilder.fromPath("/api/cinema-hall/{id}")
                    .buildAndExpand(cinemaHall.getId()).toUri();
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}

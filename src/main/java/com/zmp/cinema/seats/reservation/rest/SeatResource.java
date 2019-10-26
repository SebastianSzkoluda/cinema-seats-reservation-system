package com.zmp.cinema.seats.reservation.rest;

import com.zmp.cinema.seats.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
public class SeatResource {

    private final SeatService seatService;

    @Autowired
    public SeatResource(SeatService seatService) {
        this.seatService = seatService;
    }
}

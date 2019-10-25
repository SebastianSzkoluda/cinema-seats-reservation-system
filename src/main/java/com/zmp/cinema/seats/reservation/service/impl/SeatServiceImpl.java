package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.repository.SeatRepository;
import com.zmp.cinema.seats.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
}

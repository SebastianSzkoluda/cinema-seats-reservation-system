package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.entity.Seat;
import com.zmp.cinema.seats.reservation.repository.SeatRepository;
import com.zmp.cinema.seats.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public List<Seat> findByIdIn(Set<Long> ids) {
        return seatRepository.findByIdIn(ids);
    }

    @Override
    public boolean saveSeat(Seat seat) {
        return seatRepository.save(seat) != null;
    }

    @Override
    public boolean saveSeats(List<Seat> seats) {
        return seatRepository.saveAll(seats) != null;
    }
}

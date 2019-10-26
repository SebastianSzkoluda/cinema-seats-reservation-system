package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.entity.Reservation;
import com.zmp.cinema.seats.reservation.repository.ReservationRepository;
import com.zmp.cinema.seats.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public boolean saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation) != null;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }
}

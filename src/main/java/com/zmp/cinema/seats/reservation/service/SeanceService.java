package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.dto.SeanceRequest;
import com.zmp.cinema.seats.reservation.entity.Seance;

import java.util.List;
import java.util.Optional;

public interface SeanceService {

    boolean saveSeance(Seance seance);

    Optional<Seance> findById(Long id);

    List<Seance> loadAllSeances();

    Optional<Seance> loadSeance(SeanceRequest seanceRequest);
}

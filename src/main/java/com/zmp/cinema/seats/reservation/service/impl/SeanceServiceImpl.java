package com.zmp.cinema.seats.reservation.service.impl;

import com.google.common.collect.ImmutableList;
import com.zmp.cinema.seats.reservation.dto.SeanceRequest;
import com.zmp.cinema.seats.reservation.entity.Seance;
import com.zmp.cinema.seats.reservation.mapper.SeanceMapper;
import com.zmp.cinema.seats.reservation.repository.SeanceRepository;
import com.zmp.cinema.seats.reservation.service.CinemaHallService;
import com.zmp.cinema.seats.reservation.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public SeanceServiceImpl(SeanceRepository seanceRepository, CinemaHallService cinemaHallService) {
        this.seanceRepository = seanceRepository;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public boolean saveSeance(Seance seance) {
        return seanceRepository.save(seance) != null;
    }

    @Override
    public Optional<Seance> findById(Long id) {
        return seanceRepository.findById(id);
    }

    @Override
    public List<Seance> loadAllSeances() {
        return ImmutableList.copyOf(seanceRepository.findAll());
    }

    @Override
    public Optional<Seance> loadSeance(SeanceRequest seanceRequest) {
        ImmutableList<Seance> seances = ImmutableList.copyOf(seanceRepository.findAll());
        return cinemaHallService.loadCinemaHall(seanceRequest.getCinemaHallId())
                .map(cinemaHall -> SeanceMapper.mapSeanceRequestToSeance(seanceRequest, cinemaHall))
                .filter(s -> !seances.contains(s));
    }
}

package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.entity.Seance;
import com.zmp.cinema.seats.reservation.repository.SeanceRepository;
import com.zmp.cinema.seats.reservation.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;

    @Autowired
    public SeanceServiceImpl(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public boolean saveSeance(Seance seance) {
        return seanceRepository.save(seance) != null;
    }

    @Override
    public Optional<Seance> findById(Long id) {
        return seanceRepository.findById(id);
    }
}

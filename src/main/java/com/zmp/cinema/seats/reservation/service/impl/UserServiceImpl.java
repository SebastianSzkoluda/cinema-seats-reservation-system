package com.zmp.cinema.seats.reservation.service.impl;

import com.zmp.cinema.seats.reservation.repository.UserRepository;
import com.zmp.cinema.seats.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

package com.zmp.cinema.seats.reservation.repository;

import com.zmp.cinema.seats.reservation.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

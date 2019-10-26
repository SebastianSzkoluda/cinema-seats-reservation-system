package com.zmp.cinema.seats.reservation.service;

import com.zmp.cinema.seats.reservation.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    boolean saveCustomer(Customer customer);

    Optional<Customer> findById(Long id);
}

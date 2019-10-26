package com.zmp.cinema.seats.reservation.mapper;

import com.zmp.cinema.seats.reservation.dto.CustomerDto;
import com.zmp.cinema.seats.reservation.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapCustomerToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }

    public static Customer mapCustomerDtoToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
    }
}

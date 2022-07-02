package com.app.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlinedelivery.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

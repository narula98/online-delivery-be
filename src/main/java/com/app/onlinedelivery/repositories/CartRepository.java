package com.app.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlinedelivery.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}

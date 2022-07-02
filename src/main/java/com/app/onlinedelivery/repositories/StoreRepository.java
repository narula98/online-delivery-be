package com.app.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlinedelivery.models.Stores;

public interface StoreRepository extends JpaRepository<Stores, Long> {

}

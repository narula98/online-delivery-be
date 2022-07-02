package com.app.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlinedelivery.models.Items;

public interface ItemRepository extends JpaRepository<Items, Long> {

}

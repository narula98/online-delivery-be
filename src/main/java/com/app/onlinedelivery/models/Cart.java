package com.app.onlinedelivery.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    private String userEmail;
    private long storeId;
    private long itemID;
    private int quantity;

    public Cart(String userEmail, long storeId, long itemID, int quantity) {
        super();
        this.userEmail = userEmail;
        this.storeId = storeId;
        this.itemID = itemID;
        this.quantity = quantity;
    }
}
package com.app.onlinedelivery.dto;

import lombok.Data;

@Data
public class CartDto {

    private String userEmail;
    private long storeId;
    private String storeName;
    private String itemName;
    private long itemID;
    private int quantity;
}

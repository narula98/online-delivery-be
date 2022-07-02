package com.app.onlinedelivery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="items")
public class Items {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemid;
	private String name;
	private Integer mrp;
	private Integer discountPercent;
	private Integer availableQuantity;
	private Integer discountedSellingPrice;
	private Integer weightInGms;
	private boolean outOfStock;
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public Items(String name, Integer mrp, Integer discountPercent, Integer availableQuantity,
			Integer discountedSellingPrice, Integer weightInGms, boolean outOfStock) {
		super();
		this.name = name;
		this.mrp = mrp;
		this.discountPercent = discountPercent;
		this.availableQuantity = availableQuantity;
		this.discountedSellingPrice = discountedSellingPrice;
		this.weightInGms = weightInGms;
		this.outOfStock = outOfStock;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMrp() {
		return mrp;
	}
	public void setMrp(Integer mrp) {
		this.mrp = mrp;
	}
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Integer getDiscountedSellingPrice() {
		return discountedSellingPrice;
	}
	public void setDiscountedSellingPrice(Integer discountedSellingPrice) {
		this.discountedSellingPrice = discountedSellingPrice;
	}
	public Integer getWeightInGms() {
		return weightInGms;
	}
	public void setWeightInGms(Integer weightInGms) {
		this.weightInGms = weightInGms;
	}
	public boolean isOutOfStock() {
		return outOfStock;
	}
	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

}

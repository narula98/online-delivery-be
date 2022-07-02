package com.app.onlinedelivery.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="stores")
public class Stores {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long storeid;
	private String store_name;
	private String area;
	private String pincode;
	private Float lattitude;
	private Float longitude;

	@OneToMany
	private Set<Items> itemList;
	public Stores() {
		// TODO Auto-generated constructor stub
	}
	public Stores(String store_name, String area, String pincode, Float lattitude, Float longitude) {
		super();
		this.store_name = store_name;
		this.area = area;
		this.pincode = pincode;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	public Long getStoreid() {
		return storeid;
	}
	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Float getLattitude() {
		return lattitude;
	}
	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Set<Items> getItemList() {
		return itemList;
	}
	public void setItemList(Set<Items> itemList) {
		this.itemList = itemList;
	}
	
	

}

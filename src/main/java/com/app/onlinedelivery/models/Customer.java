package com.app.onlinedelivery.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerid;
	private String email;
	private String password;
	private String address;
	private float lattitude;
	private float longitude;
	
	public Customer(String email, String password, String address, float lattitude, float longitude) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	
	public Customer() {
		super();
	}


	public Long getCustomerId() {
		return customerid;
	}
	public void setCustomerId(Long customerId) {
		this.customerid = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getLattitude() {
		return lattitude;
	}
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, customerid, email, lattitude, longitude, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(customerid, other.customerid)
				&& Objects.equals(email, other.email)
				&& Float.floatToIntBits(lattitude) == Float.floatToIntBits(other.lattitude)
				&& Float.floatToIntBits(longitude) == Float.floatToIntBits(other.longitude)
				&& Objects.equals(password, other.password);
	}
	
	

}

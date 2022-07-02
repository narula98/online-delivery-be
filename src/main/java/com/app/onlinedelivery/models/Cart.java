package com.app.onlinedelivery.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cart")
@Getter
@Setter
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartid;
	
	@OneToMany
	private Set<Items> cartItems;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}
	
}

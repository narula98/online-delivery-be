package com.app.onlinedelivery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.onlinedelivery.models.Cart;
import com.app.onlinedelivery.models.Customer;
import com.app.onlinedelivery.models.Items;
import com.app.onlinedelivery.models.Stores;
import com.app.onlinedelivery.repositories.CustomerRepository;
import com.app.onlinedelivery.repositories.ItemRepository;
import com.app.onlinedelivery.repositories.StoreRepository;

@SpringBootApplication
public class OnlinedeliveryApplication implements CommandLineRunner{
    
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinedeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer("sahilnarula98@gmail.com", "pwd", "adawd", 1.2f, 342.0f);
		Cart cart = new Cart();
		Items item1 = new Items("elaichi", 20, 1, 3, 18, 100, false);
		Items item2 = new Items("haldi", 22, 1, 3, 20, 100, false);
		Set<Items> itemList = new HashSet<Items>();
		itemList.add(item1);
		itemList.add(item2);
		
		Stores store1 = new Stores("Big Basket", "pipliyahana", "452001", 123.0f, 123.3f);
		store1.setItemList(itemList);
		itemRepository.save(item1);
		itemRepository.save(item2);
		storeRepository.save(store1);
		
		cart.setCartItems(itemList);
		
		
		customer.setCustomerCart(cart);
		customerRepository.save(customer);
	}

}

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
import com.app.onlinedelivery.repositories.CartRepository;
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
	
	@Autowired
	private CartRepository cartRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinedeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Stores s = new Stores("sshop", "red", "adsadd111", 111f, 222f);
        System.out.println("store id "+ s.getStoreid());

        Items i = new Items("haldi",1000,1,5,10,250,false);
        i = itemRepository.save(i);
        System.out.println("item id "+i.getItemid());
        Set<Items> itemSet = new HashSet<Items>();
        itemSet.add(i);
        s.setItemList(itemSet);
        s = storeRepository.save(s);
        Customer u = new Customer();
        u.setAddress("sadwadaw");
        u.setEmail("dummyuser@email");
        u.setPassword("password");
        u = customerRepository.save(u);

        System.out.println("user id "+ u.getCustomerId());
        System.out.println("user email "+ u.getEmail());
	}

}

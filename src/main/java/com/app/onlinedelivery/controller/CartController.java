package com.app.onlinedelivery.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.onlinedelivery.dto.CartDto;
import com.app.onlinedelivery.exception.ResourceNotFound;
import com.app.onlinedelivery.models.Cart;
import com.app.onlinedelivery.models.Customer;
import com.app.onlinedelivery.repositories.CartRepository;
import com.app.onlinedelivery.repositories.CustomerRepository;
import com.app.onlinedelivery.repositories.ItemRepository;
import com.app.onlinedelivery.repositories.StoreRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private StoreRepository storeRepository;

	@PostMapping("/addtoCart")
	public ResponseEntity<?> addToCart(@RequestBody CartDto cartDto) throws ResourceNotFound {

		List<Customer> ul = userRepository.findAll().stream().filter(u -> u.getEmail().equals(cartDto.getUserEmail()))
				.collect(Collectors.toList());
		if (ul.isEmpty()) {
			throw new ResourceNotFound("User does not exist");

		}
		if (storeRepository.findById(cartDto.getStoreId()).isEmpty()) {
			throw new ResourceNotFound("store does not exist");
		}
		if (itemRepository.findById(cartDto.getItemID()).isEmpty()) {
			throw new ResourceNotFound("item does not exist");
		}
		List<Cart> listofAllCarts = cartRepository.findAll();
		List<Cart> userCart = listofAllCarts.stream().filter(x -> x.getUserEmail().equals(cartDto.getUserEmail()))
				.collect(Collectors.toList());
		int flag = 0;
		for (Cart c : userCart) {
			if (c.getStoreId() == cartDto.getStoreId() && c.getItemID() == cartDto.getItemID()) {
				flag = 1;
				c.setQuantity(c.getQuantity() + cartDto.getQuantity());
				return new ResponseEntity(cartRepository.save(c), HttpStatus.ACCEPTED);
			}
		}
		if (flag == 0) {
			Cart c = new Cart(cartDto.getUserEmail(), cartDto.getStoreId(), cartDto.getItemID(), cartDto.getQuantity());
			return new ResponseEntity(cartRepository.save(c), HttpStatus.ACCEPTED);
		}
		return null;

	}

}

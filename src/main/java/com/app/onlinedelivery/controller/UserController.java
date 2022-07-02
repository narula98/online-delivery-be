package com.app.onlinedelivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.app.onlinedelivery.dto.CustomerDto;
import com.app.onlinedelivery.dto.UserCartDTO;
import com.app.onlinedelivery.exception.ResourceNotFound;
import com.app.onlinedelivery.models.Cart;
import com.app.onlinedelivery.models.Customer;
import com.app.onlinedelivery.repositories.CartRepository;
import com.app.onlinedelivery.repositories.CustomerRepository;
import com.app.onlinedelivery.repositories.ItemRepository;
import com.app.onlinedelivery.repositories.StoreRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private StoreRepository storeRepository;
	
	@PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody CustomerDto.CustomerLogin customerLogin) throws ResourceNotFound
    {

        List<Customer> lu = customerRepository.findAll().stream().filter(x-> x.getEmail().equals(customerLogin.getEmail()) 
                && x.getPassword().equals(customerLogin.getPassword())).collect(Collectors.toList());
        if(!lu.isEmpty())
        {
            return new ResponseEntity(lu.get(0), HttpStatus.ACCEPTED);
        }
        
        throw new ResourceNotFound("not found");

   }
	
	  @PostMapping("/signup")
	    public ResponseEntity<?> userSignup(@RequestBody CustomerDto.CustomerSignup customerSignup)
	    {
	        List<Customer> lu = customerRepository.findAll().stream().filter(x-> x.getEmail().equals(customerSignup.getEmail())).
	                collect(Collectors.toList());
	        if(lu.isEmpty())
	        {
	        	Customer u = new Customer();
	            u.setEmail(customerSignup.getEmail());
	            u.setPassword(customerSignup.getPassword());
	            u.setAddress(customerSignup.getAddress());
	            u.setLattitude(customerSignup.getLattitude());
	            u.setLongitude(customerSignup.getLongitude());
	            u = customerRepository.save(u);
	            return new ResponseEntity(u, HttpStatus.ACCEPTED);
	        }
	        return new ResponseEntity("emailid already exists", HttpStatus.NOT_FOUND);
	    }
	  
	  @GetMapping("/userCart/{email}")
	    public ResponseEntity<?> userCartbyEmail(@PathVariable String email) throws ResourceNotFound
	    {
	        List<Customer> ul = customerRepository.findAll().stream().filter(u -> u.getEmail().equals(email))
	                .collect(Collectors.toList());
	        if (ul.isEmpty()) {
	            throw new ResourceNotFound("User does not exist");

	        }

	        Customer u = ul.get(0);

	        List<Cart> listOfUserCarts = cartRepository.findAll().stream().filter(x-> x.getUserEmail().equals(u.getEmail()))
	                .collect(Collectors.toList());
	        if(!listOfUserCarts.isEmpty())
	        {
	            List<UserCartDTO> ucdto = new ArrayList<UserCartDTO>();
	            for(Cart c : listOfUserCarts)
	            {
	                UserCartDTO tempucdto = new UserCartDTO();
	                tempucdto.setItemID(c.getItemID());
	                tempucdto.setItemName(itemRepository.getReferenceById(c.getItemID()).getName());
	                tempucdto.setQuantity(c.getQuantity());
	                tempucdto.setStoreId(c.getStoreId());
	                tempucdto.setStoreName(storeRepository.getReferenceById(c.getStoreId()).getStore_name());
	                tempucdto.setUserEmail(c.getUserEmail());
	                ucdto.add(tempucdto);
	            }
	            return new ResponseEntity(ucdto, HttpStatus.ACCEPTED);
	            //return new ResponseEntity(listOfUserCarts, HttpStatus.ACCEPTED);
	        }
	        return new ResponseEntity("user has no items in cart", HttpStatus.ACCEPTED);
	    }
}

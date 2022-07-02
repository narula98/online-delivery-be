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

import com.app.onlinedelivery.dto.CustomerDto;
import com.app.onlinedelivery.models.Customer;
import com.app.onlinedelivery.repositories.CustomerRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody CustomerDto.CustomerLogin customerLogin)
    {

        List<Customer> lu = customerRepository.findAll().stream().filter(x-> x.getEmail().equals(customerLogin.getEmail()) 
                && x.getPassword().equals(customerLogin.getPassword())).collect(Collectors.toList());
        if(!lu.isEmpty())
        {
            return new ResponseEntity(lu.get(0), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("user not found", HttpStatus.NOT_FOUND);

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
	        return new ResponseEntity("emailid already exists", HttpStatus.FORBIDDEN);
	    }
}

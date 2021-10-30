package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.exception.CustomerNotFoundException;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;


@RestController
public class CustomerResource {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path="/customers")
	public List<Customer> retrieveCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping(path="/customers/{theId}")
	public Customer retrieveCustomer(@PathVariable Integer theId) {
		Customer theCustomer = customerService.getCustomer(theId);
		return theCustomer;
	}
	
	//POST URI : localhost:8080/customers
		//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
		//Response : status code : 201 , URI --- > new resource in a response header
		@PostMapping(path = "/customers")
		public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer theCustomer) {
			Customer savedCustomer = customerService.saveCustomer(theCustomer);
			
			// location : localhost:8080/customers/4
			URI location = ServletUriComponentsBuilder
					 .fromCurrentRequest()
					 .path("/{theId}")
					 .buildAndExpand(savedCustomer.getId())
					 .toUri();
			return ResponseEntity.created(location).build();
		}
		
		// assigment  : update the customer @PutMapping
		//response : 204
		@PutMapping(path="/customers/{theId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void updateCustomer(@PathVariable Integer theId,@RequestBody Customer theCustomer) {
			Customer savedCustomer = customerService.getCustomer(theId);
			
			savedCustomer.setId(theId);
			savedCustomer.setName(theCustomer.getName());
			savedCustomer.setPhone(theCustomer.getPhone());
			savedCustomer.setEmail(theCustomer.getEmail());
			
		}
		
		@DeleteMapping(path="/customers/{theId}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteCustomer(@PathVariable Integer theId) {
			Customer theCustomer = customerService.getCustomer(theId);
			if ( theCustomer == null) {
				throw new CustomerNotFoundException("id -" +theId);
			}
			
			customerService.deleteCustomer(theId);
		}
	
	
}

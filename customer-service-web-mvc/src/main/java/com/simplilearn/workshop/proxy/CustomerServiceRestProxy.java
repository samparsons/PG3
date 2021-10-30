package com.simplilearn.workshop.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.workshop.model.Customer;

@FeignClient(name = "customer-service-rest",url="localhost:8080")
public interface CustomerServiceRestProxy {
	@GetMapping(path="/customers")
	public List<Customer> retrieveCustomers();
	@GetMapping(path = "/customers/{theId}")
	public Customer retriveCustomer(@PathVariable Integer theId);
	@PostMapping(path = "/customers")
	public ResponseEntity<Customer> createCustomer( @RequestBody Customer theCustomer);
	@PutMapping("/customers/{theId}")
	public void updateCustomer(@PathVariable Integer theId,@RequestBody Customer theCustomer);
	@DeleteMapping("/customers/{theId}")
	public void deleteCustomer(@PathVariable Integer theId) ;
}

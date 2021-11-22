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

import com.simplilearn.workshop.model.Customers;

@FeignClient(name = "sporty-shoes-rest-jpa-h2",url="localhost:8080")
public interface CustomerServiceRestProxy {
	@GetMapping(path="/customers")
	public List<Customers> retrieveCustomers();
	@GetMapping(path="/customers/{name}/asc")
	public List<Customers> getByNameAsc(@PathVariable String name);
	@GetMapping(path="/customers/{name}/desc")
	public List<Customers> getByNameDesc(@PathVariable String name);
	@GetMapping(path = "/customers/{theId}")
	public Customers retrieveCustomer(@PathVariable Integer theId);
	@PostMapping(path = "/customers")
	public ResponseEntity<Customers> createCustomers(@RequestBody Customers theCustomers);
	@PutMapping("/customers/{theId}")
	public void updateCustomer(@PathVariable Integer theId,@RequestBody Customers theCustomers);
	@DeleteMapping("/customers/{theId}")
	public void deleteCustomer(@PathVariable Integer theId) ;
}

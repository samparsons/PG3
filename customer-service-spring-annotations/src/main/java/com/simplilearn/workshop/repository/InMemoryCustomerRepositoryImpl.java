package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;

//@Repository bean id (default, class name) = inMemoryCustomerRepositoryImpl

@Repository(value = "customerRepository")

public class InMemoryCustomerRepositoryImpl implements CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<>();
	
	static {
		customers.add( new Customer(1L,"sam","1234567890","sam@email.com"));
		customers.add( new Customer(2L,"georgi","1234567890","georgi@email.com"));
		customers.add( new Customer(3L,"puck","1234567890","puck@email.com"));
	}
	
	@Override
	public List<Customer> findAll() {
		return customers;
	}
	
}
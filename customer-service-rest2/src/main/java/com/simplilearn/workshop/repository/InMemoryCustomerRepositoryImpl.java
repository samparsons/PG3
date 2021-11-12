package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;

@Repository(value = "customerRepository")
public class InMemoryCustomerRepositoryImpl implements CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	
	static {
		customers.add(new Customer(1,"Sam","12345678","sparsons@email.com"));
		customers.add(new Customer(2,"Georgi","12345678","georgi@email.com"));
		customers.add(new Customer(3,"Puck","12345678","puck@email.com"));
	}

	private static int customerCount = 3;
	
	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		if(theCustomer.getId() == null) {
			theCustomer.setId(++customerCount);
		}
		
		customers.add(theCustomer);
		
		return theCustomer; 
	}

	@Override
	public Customer getCustomer(Integer theId) {
		for(Customer theCustomer : customers) {
			if(theCustomer.getId() == theId) {
				return theCustomer;
			}
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer theId) {
		Iterator<Customer> iterator = customers.iterator();
		while( iterator.hasNext()) {
			Customer theCustomer = iterator.next();
			if(theCustomer.getId() == theId) {
				iterator.remove();
				return theCustomer;
			}
		}
		return null;
	}

}

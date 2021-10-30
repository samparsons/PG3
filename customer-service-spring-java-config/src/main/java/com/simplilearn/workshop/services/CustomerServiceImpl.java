package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.InMemoryCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository ;
	
	
	
	
	public CustomerServiceImpl() {
		super();
	}

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		System.out.println("Spring called a CustomerServiceImpl (constructor) method to inject customerRepository");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> retriveAllCustomers() {
		return customerRepository.findAll();
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Spring called a setCustomerRepository method to inject customerRepository");
		this.customerRepository = customerRepository;
	}
	
	
	
}

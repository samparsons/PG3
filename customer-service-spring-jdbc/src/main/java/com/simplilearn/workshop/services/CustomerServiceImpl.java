package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImpl() {
		super();
	}
	
	// Parameterized constructor
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("spring called setter method to inject a bean 'customerRepository'");
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll()	;
	}
	
	@Override
	public Integer countAllCustomers() {
		return customerRepository.findNoOfCustomers();
	}
}

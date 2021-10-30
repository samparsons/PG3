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

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomers();
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		return customerRepository.saveCustomer(theCustomer);
	}

	@Override
	public Customer getCustomer(Integer theId) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomer(theId);
	}

	@Override
	public Customer deleteCustomer(Integer theId) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomer(theId);
	}
	
	

}

package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customers;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customers> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customers saveCustomer(Customers theCustomer) {
		// TODO Auto-generated method stub
		return customerRepository.save(theCustomer);
	}

	@Override
	public Customers getCustomer(Integer theId) {
		// TODO Auto-generated method stub
		return customerRepository.getById(theId);
	}

	@Override
	public void deleteCustomer(Integer theId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(theId);
	}
	
	

}

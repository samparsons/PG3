package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customers;

public interface CustomerService {
	
	
	public List<Customers> getCustomers();
	public Customers saveCustomer(Customers theCustomer);
	public Customers getCustomer(Integer theId);
	public void deleteCustomer(Integer theId);

}

package com.simplilearn.workshop;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		// depends on customer service 
		
		CustomerService customerService = new CustomerServiceImpl();
		
		List<Customer> loadedCustomers = customerService.retriveAllCustomers();
		
		/*
		 * for (Customer c : loadedCustomers) {
		 * 	System.out.println(c.getName());
		 * }
		 * */
		//same as above but with lambda exercise
		loadedCustomers.forEach(customer -> System.out.println(customer.getName()));		
	}
}

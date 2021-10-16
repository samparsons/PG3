package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		// spring container
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// depends on customer service 
		
		//CustomerService customerService = new CustomerServiceImpl();
		
		CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
		
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

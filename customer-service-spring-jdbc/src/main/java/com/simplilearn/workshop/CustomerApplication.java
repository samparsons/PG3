package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.workshop.config.MainConfig;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;

public class CustomerApplication {
	
	public static void main(String[] args) {
		ApplicationContext spring_container = new AnnotationConfigApplicationContext(MainConfig.class);
		CustomerService customerService = spring_container.getBean("customerService",CustomerService.class);
		System.out.println("the no of customers in database: "+ customerService.countAllCustomers());
		
		List<Customer> list_of_customers = customerService.retrieveAllCustomers();
		
		list_of_customers.forEach(customer ->  System.out.println(customer.getName()));
	}
}

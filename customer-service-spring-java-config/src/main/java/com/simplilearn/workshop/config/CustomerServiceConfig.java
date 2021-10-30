package com.simplilearn.workshop.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.InMemoryCustomerRepositoryImpl;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

@Configuration
public class CustomerServiceConfig {
	@Bean
	public CustomerRepository customerRepository() {
		return new InMemoryCustomerRepositoryImpl();
		}
	@Bean
	@Scope("singleton")
	public CustomerService customerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCustomerRepository(customerRepository());
		return customerService;
	}

}

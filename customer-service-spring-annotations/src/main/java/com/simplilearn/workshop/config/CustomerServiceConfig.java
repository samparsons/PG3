package com.simplilearn.workshop.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.InMemoryCustomerRepositoryImpl;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

@Configuration
//do not use root com.simplilearn.workshop bc will make everything run longer
@ComponentScan(basePackages = "com.simplilearn.workshop.repository,com.simplilearn.workshop.services")
public class CustomerServiceConfig {
	
	

}

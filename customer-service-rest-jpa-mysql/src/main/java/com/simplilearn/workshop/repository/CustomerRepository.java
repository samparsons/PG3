package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//public Customer FindByEmail(String email);
	
	
}

package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.workshop.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{
	
	//public Customer FindByEmail(String email);
	
	
}

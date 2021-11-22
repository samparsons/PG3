package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.workshop.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{
	
	List<Customers> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
	List<Customers> findByNameContainingIgnoreCaseOrderByNameDesc(String name);
}

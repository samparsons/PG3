package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Admins;
import com.simplilearn.workshop.model.Customers;
import com.simplilearn.workshop.model.Purchases;

public interface AdminRepository extends JpaRepository<Admins, Integer>{
	
	List<Customers> findByNameContaining(String name);
	//for purchases - https://stackoverflow.com/questions/13154818/how-to-define-a-jpa-repository-query-with-a-join
	
	
	
}

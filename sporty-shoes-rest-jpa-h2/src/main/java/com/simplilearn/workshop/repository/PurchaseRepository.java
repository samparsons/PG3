package com.simplilearn.workshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Purchases;

public interface PurchaseRepository extends JpaRepository<Purchases, Integer>{
	
	List<Purchases> findByPurchaseDate(String purchaseDate);

}

package com.simplilearn.workshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.simplilearn.workshop.model.Purchases;

public interface PurchaseRepository extends JpaRepository<Purchases, Integer>{
	
	List<Purchases> findByPurchaseDateAndProductIdOrCategory(Date date,Integer productId,String category);

}

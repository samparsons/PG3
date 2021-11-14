package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.workshop.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{
	
	@Query("SELECT new com.simplilearn.workshop.model.Products(p.productId,p.name,p.description,p.price,p.imgPathURL) FROM Products p")
    List<Products> findAll();

}

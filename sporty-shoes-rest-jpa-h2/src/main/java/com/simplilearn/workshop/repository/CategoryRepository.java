package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;

public interface CategoryRepository extends JpaRepository<Categories, Integer>{
	
	@Query("SELECT new com.simplilearn.workshop.model.Categories(c.categoryName) FROM Categories c WHERE c.productId = ?1")
    List<Categories> findAllByProduct(Integer theId);
	
	
}

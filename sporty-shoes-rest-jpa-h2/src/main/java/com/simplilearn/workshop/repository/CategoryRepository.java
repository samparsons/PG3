package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.workshop.model.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer>{
	
	//public List<Categories> findByCategory(String category);
	
	
}

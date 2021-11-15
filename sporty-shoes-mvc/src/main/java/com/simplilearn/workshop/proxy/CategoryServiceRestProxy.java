package com.simplilearn.workshop.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;

@FeignClient(name = "sporty-shoes-rest-jpa-h2",url="localhost:8080")
public interface CategoryServiceRestProxy {
	@GetMapping(path="/categories")
	public List<Categories> retrieveCategories();
	@GetMapping(path = "/categories/{theId}")
	public Categories retrieveCategory(@PathVariable Integer theId);
	
	@GetMapping(path = "/categories/product/{theId}")
	public List<Categories> retrieveCategoryByProduct(@PathVariable Integer theId);
	
	@PostMapping(path = "/categories")
	public ResponseEntity<Categories> createCategories(@RequestBody Categories theCategories);
	@PutMapping("/categories/{theId}")
	public void updateCategory(@PathVariable Integer theId,@RequestBody Categories theCategories);
	@DeleteMapping("/categories/{theId}")
	public void deleteCategory(@PathVariable Integer theId) ;
}

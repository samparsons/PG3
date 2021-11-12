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

import com.simplilearn.workshop.model.Products;

@FeignClient(name = "sporty-shoes-rest-jpa-h2",url="localhost:8080")
public interface ProductServiceRestProxy {
	@GetMapping(path="/products")
	public List<Products> retrieveProducts();
	@GetMapping(path = "/products/{theId}")
	public Products retrieveProduct(@PathVariable Integer theId);
	@PostMapping(path = "/products")
	public ResponseEntity<Products> createProducts(@RequestBody Products theProducts);
	@PutMapping("/products/{theId}")
	public void updateProduct(@PathVariable Integer theId,@RequestBody Products theProducts);
	@DeleteMapping("/products/{theId}")
	public void deleteProduct(@PathVariable Integer theId) ;
}

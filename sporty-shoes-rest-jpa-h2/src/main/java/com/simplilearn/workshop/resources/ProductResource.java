package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.exception.ProductNotFoundException;
import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;
import com.simplilearn.workshop.services.CategoryService;
import com.simplilearn.workshop.services.ProductService;


@RestController
public class ProductResource {
	@Autowired
	private ProductService productService;
	//private CategoryService categoryService;
	
	@GetMapping(path="/products")
	public List<Products> retrieveProducts() {
		return productService.getProducts();
	}
	
	@GetMapping(path="/products/{theId}")
	public Products retrieveProduct(@PathVariable Integer theId) {
		Products theProduct = productService.getProduct(theId);
		return theProduct;
	}
	
	//POST URI : localhost:8080/Products
		//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
		//Response : status code : 201 , URI --- > new resource in a response header
		@PostMapping(path = "/products")
		public ResponseEntity<Products> createProduct(@Valid @RequestBody Products theProduct) {
			Products savedProduct = productService.saveProduct(theProduct);
			
			
			// location : localhost:8080/Products/4
			URI location = ServletUriComponentsBuilder
					 .fromCurrentRequest()
					 .path("/{theId}")
					 .buildAndExpand(savedProduct.getId())
					 .toUri();
			return ResponseEntity.created(location).build();
		}
		
		// assignment  	: update the Product @PutMapping
				//response 		: 204
				@PutMapping(path="/products/{theId}")
				@ResponseStatus(HttpStatus.NO_CONTENT)
				public void updateProduct(@PathVariable Integer theId, @RequestBody Products theProduct) {
					Products savedProduct = productService.getProduct(theId);
					savedProduct.setName(theProduct.getName());
					savedProduct.setDescription(theProduct.getDescription());
					savedProduct.setPrice(theProduct.getPrice());
					savedProduct.setImgPathURL(theProduct.getImgPathURL());
				}
		
		@DeleteMapping(path="/products/{theId}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteProduct(@PathVariable Integer theId) {
			Products theProduct = productService.getProduct(theId);
			if ( theProduct == null) {
				throw new ProductNotFoundException("id -" +theId);
			}
			
			productService.deleteProduct(theId);
		}
	
	
}

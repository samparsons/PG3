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

import com.simplilearn.workshop.exception.CategoryNotFoundException;
import com.simplilearn.workshop.exception.ProductNotFoundException;
import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;
import com.simplilearn.workshop.services.CategoryService;
import com.simplilearn.workshop.services.ProductService;


@RestController
public class CategoryResource {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/categories")
	public List<Categories> retrieveCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping(path="/categories/{theId}")
	public Categories retrieveCategory(@PathVariable Integer theId) {
		Categories theCategory = categoryService.getCategory(theId);
		return theCategory;
	}
	
	@GetMapping(path="/categories/product/{theId}")
	public List<Categories> retrieveCategoryByProduct(@PathVariable Integer theId) {
		List<Categories> theCategory = categoryService.getCategoriesByProduct(theId);
		System.out.println("CategoryResource//");
		for(Categories c:theCategory) {
			System.out.println("cid: "+c.getId()+" pid:"+c.getProductId()+" cn:"+c.getCategory());
		}
		return theCategory;
	}
	
	
	
	//POST URI : localhost:8080/Categories
		//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
		//Response : status code : 201 , URI --- > new resource in a response header
		@PostMapping(path = "/categories")
		public ResponseEntity<Categories> createCategory(@Valid @RequestBody Categories theCategory) {
			Categories savedCategory = categoryService.saveCategory(theCategory);
			
			// location : localhost:8080/Categories/4
			URI location = ServletUriComponentsBuilder
					 .fromCurrentRequest()
					 .path("/{theId}")
					 .buildAndExpand(savedCategory.getId())
					 .toUri();
			return ResponseEntity.created(location).build();
		}
		
		// assigment  : update the Category @PutMapping
		//response : 204
		@PutMapping(path="/categories/{theId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void updateCategory(@PathVariable Integer theId,@RequestBody Categories theCategory) {
			Categories savedCategory = categoryService.getCategory(theId);
			savedCategory.setProductId(theCategory.getProductId());
			savedCategory.setCategory(theCategory.getCategory());
		}
		
		// assignment  	: add categories
		//response 		: 204
		@PutMapping(path="/categories/addCategory/{ProductId}/{CategoryName}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void addCategory(@PathVariable Integer ProductId, @PathVariable String CategoryName) {
			Categories newCat = new Categories(ProductId,CategoryName);
			categoryService.saveCategory(newCat);
		}
		
		@DeleteMapping(path="/categories/{theId}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteProduct(@PathVariable Integer theId) {
			Categories theCategory = categoryService.getCategory(theId);
			if ( theCategory == null) {
				throw new CategoryNotFoundException("id -" +theId);
			}
			categoryService.deleteCategory(theId);
		}
		
		@DeleteMapping(path="/categories/{prodId}/{catName}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteCategory(@PathVariable Integer prodId,String catName) {
			Products theProduct = productService.getProduct(prodId);
			List<Categories> cats = categoryService.getCategoriesByProduct(prodId);
			
			List<Categories> newCats = new ArrayList<Categories>();
			if ( cats.size() == 0) {
				throw new CategoryNotFoundException("name: " +catName);
			} else {
				for(Categories c : cats) {
					if(!c.getCategory().equals(catName)) {
						categoryService.deleteCategory(c.getId());
					}
				}
			}
		}
}

package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

import com.simplilearn.workshop.exception.PurchaseNotFoundException;
import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;
import com.simplilearn.workshop.model.Purchases;
import com.simplilearn.workshop.services.CategoryService;
import com.simplilearn.workshop.services.ProductService;
import com.simplilearn.workshop.services.PurchaseService;


@RestController
public class PurchaseResource {
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/purchases")
	public List<Purchases> retrievePurchases() {
		return purchaseService.getPurchases();
	}
	
	@GetMapping(path="/purchases/{theId}")
	public Purchases retrievePurchase(@PathVariable Integer theId) {
		Purchases thePurchase = purchaseService.getPurchase(theId);
		return thePurchase;
	}
	
	@GetMapping(path="/purchases/{date}/{productId}/{category}")
	public List<Purchases> getByPurchasedDateAndProductId(@PathVariable Date date,@PathVariable Integer productId,@PathVariable String category) {
		List<Purchases> thePurchases = purchaseService.getByPurchasedDateAndProductId(date, productId,category);
		List<Purchases> theFilteredPurchases = new ArrayList<Purchases>();
		for(Purchases pu:thePurchases) {
			List<Categories> theCategories = categoryService.getCategoriesByProduct(productId);
			Products product = productService.getProduct(productId);
			for(Categories c:theCategories) {
				if(c.getCategory().equals(category)) {
					pu.setCategories(theCategories);
					Double price = Double.parseDouble(product.getPrice());
					pu.setPrice(price);
				}
			}
			theFilteredPurchases.add(pu);
		}
		
		return theFilteredPurchases;
	}

	
	
	
	
	//POST URI : localhost:8080/Purchases
		//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
		//Response : status code : 201 , URI --- > new resource in a response header
		@PostMapping(path = "/purchases")
		public ResponseEntity<Purchases> createPurchase(@Valid @RequestBody Purchases thePurchase) {
			Purchases savedPurchase = purchaseService.savePurchase(thePurchase);
			
			// location : localhost:8080/Purchases/4
			URI location = ServletUriComponentsBuilder
					 .fromCurrentRequest()
					 .path("/{theId}")
					 .buildAndExpand(savedPurchase.getPurchaseId())
					 .toUri();
			return ResponseEntity.created(location).build();
		}
		
		// assigment  : update the Purchase @PutMapping
		//response : 204
		@PutMapping(path="/purchases/{theId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void updatePurchase(@PathVariable Integer theId,@RequestBody Purchases thePurchase) {
			Purchases savedPurchase = purchaseService.getPurchase(theId);
			savedPurchase.setPurchaseId(theId);
			savedPurchase.setProductId(thePurchase.getProductId());
			savedPurchase.setCustomerId(thePurchase.getCustomerId());
			savedPurchase.setPurchaseDate(thePurchase.getPurchaseDate());
		}
		
		@DeleteMapping(path="/Purchases/{theId}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deletePurchase(@PathVariable Integer theId) {
			Purchases thePurchase = purchaseService.getPurchase(theId);
			if ( thePurchase == null) {
				throw new PurchaseNotFoundException("id -" +theId);
			}
			
			purchaseService.deletePurchase(theId);
		}
	
	
}

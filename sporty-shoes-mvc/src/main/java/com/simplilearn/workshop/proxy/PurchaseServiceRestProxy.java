package com.simplilearn.workshop.proxy;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.workshop.model.Purchases;

@FeignClient(name = "sporty-shoes-rest-jpa-h2",url="localhost:8080")
public interface PurchaseServiceRestProxy {
	@GetMapping(path="/purchases")
	public List<Purchases> retrievePurchases();
	@GetMapping(path="/purchases/{date}/{category}")
	public List<Purchases> getByPurchasedDate(@PathVariable String date,@PathVariable String category);
	
	@GetMapping(path = "/purchases/{theId}")
	public Purchases retrievePurchase(@PathVariable Integer theId);
	
	@PostMapping(path = "/purchases")
	public ResponseEntity<Purchases> createPurchases(@RequestBody Purchases thePurchases);
	@PutMapping("/purchases/{theId}")
	public void updatePurchase(@PathVariable Integer theId,@RequestBody Purchases thePurchases);
	@DeleteMapping("/purchases/{theId}")
	public void deletePurchase(@PathVariable Integer theId);
}

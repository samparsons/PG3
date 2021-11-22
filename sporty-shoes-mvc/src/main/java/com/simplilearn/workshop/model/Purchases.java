package com.simplilearn.workshop.model;

import java.util.Date;
import java.util.List;



public class Purchases {
	
	private Integer purchaseId;
	private Integer productId;
	
	private Integer customerId;

	private Date purchaseDate;
	
	private Double price;
	
	private List<Categories> categories;
	
	private String category;
	
	
	
	public Purchases() {
		super();
	}
	
	
	
	
	
	


	public Purchases(Integer purchaseId, Integer productId, Integer customerId, Date purchaseDate, Double price,
			List<Categories> categories, String category) {
		super();
		this.purchaseId = purchaseId;
		this.productId = productId;
		this.customerId = customerId;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.categories = categories;
		this.category = category;
	}








	public Integer getPurchaseId() {
		return purchaseId;
	}



	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}



	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public Date getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public List<Categories> getCategories() {
		return categories;
	}



	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	private Date setDate() {
		long now = new Date().getTime();
		Date today =  new Date(now);
		return today;
	}

	
	
	
	
	

}

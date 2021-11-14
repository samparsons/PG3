package com.simplilearn.workshop.model;

public class Categories {
	
	private Integer categoryId;
	private Integer productId;
	private String categoryName;
	
	public Categories() {
		super();
	}
	
	

	/*
	 * public Categories(@NotNull Products product, @NotNull String categoryName) {
	 * super(); this.product = product; this.categoryName = categoryName; }
	 * 
	 * public Products getProduct() { return product; }
	 * 
	 * public void setProduct(Products product) { this.product = product; }
	 */

	public Categories(Integer productId, String categoryName) {
		super();
		this.productId = productId;
		this.categoryName = categoryName;
	}
	
	public Categories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return categoryId;
	}
	
	
	

}

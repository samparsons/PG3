package com.simplilearn.workshop.model;

public class Categories {
	
	private Integer categoryId;
	private Integer productId;
	private String categoryName;
	
	public Categories() {
		super();
	}

	public Categories(Integer categoryId,Integer productId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
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
	
	public void setId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	

}

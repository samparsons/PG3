package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private Integer id;
	private String name;
	private String description;
	private String price;
	private String imgPath;
	private List<String> categories;
	private List<Purchases> purchases; 
	
	
	
	public Products(String name, String description, String price, String imgPath) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgPath = imgPath;
		categories = new ArrayList<String>();
		purchases = new ArrayList<Purchases>();
	}

	public Products() {
		super();
	}
	
	public List<Purchases> getPurchasees() {
		return purchases;
	}
	
	public void setPurchasees(Purchases purchase) {
		purchases.add(purchase);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(String category) {
		categories.add(category);
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", imgPath="
				+ imgPath + ", categories=" + categories + "]";
	}
	
	
	

}

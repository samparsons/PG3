package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private Integer id;
	private String name;
	private String description;
	private String price;
	private String imgPathURL;
	private List<Categories> categories;
	//private List<Purchases> purchases; 
	
	
	
	public Products(Integer id,String name, String description, String price, String imgPathURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgPathURL = imgPathURL;
		categories = new ArrayList<Categories>();
		//purchases = new ArrayList<Purchases>();
	}

	public Products() {
		super();
	}
	
	/*
	 * public List<Purchases> getPurchasees() { return purchases; }
	 * 
	 * public void setPurchasees(Purchases purchase) { purchases.add(purchase); }
	 */
	
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
	
	
	

	public String getImgPathURL() {
		return imgPathURL;
	}

	public void setImgPathURL(String imgPathURL) {
		this.imgPathURL = imgPathURL;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> cats) {
		this.categories = cats;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imgPathURL=" + imgPathURL + ", categories=" + categories + "]";
	}

	
	
	/*
	 * @Override public String toString() { return "Products [id=" + id + ", name="
	 * + name + ", description=" + description + ", price=" + price + ", imgPath=" +
	 * imgPath + ", categories=" + categories + "]"; }
	 */
	
	
	

}

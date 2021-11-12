package com.simplilearn.workshop.model;

import java.util.Date;


public class Purchases {
	
	private Integer id;
	private Customers customer;
	private Products product;
	private Date purchaseDate = setDate();
	
	
	
	public Purchases() {
		super();
	}
	
	private Date setDate() {
		long now = new Date().getTime();
		Date today =  new Date(now);
		return today;
	}

	public Integer getId() {
		return id;
	}


	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
	

}

package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;

public interface ProductService {
	
	
	public List<Products> getProducts();
	public Products saveProduct(Products theProduct);
	public Products getProduct(Integer theId);
	public void deleteProduct(Integer theId);

}

package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;
import com.simplilearn.workshop.repository.ProductRepository;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Products> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Products saveProduct(Products theProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(theProduct);
	}

	@Override
	public Products getProduct(Integer theId) {
		// TODO Auto-generated method stub
		return productRepository.getById(theId);
	}

	@Override
	public void deleteProduct(Integer theId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(theId);
	}
}

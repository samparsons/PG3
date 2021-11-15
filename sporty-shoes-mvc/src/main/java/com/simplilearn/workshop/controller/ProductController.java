package com.simplilearn.workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.model.Products;
import com.simplilearn.workshop.proxy.CategoryServiceRestProxy;
import com.simplilearn.workshop.proxy.ProductServiceRestProxy;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceRestProxy productServiceRestProxy;
	
	@Autowired
	private CategoryServiceRestProxy categoryServiceRestProxy;
	
	@GetMapping(path = "/products/list")
	public ModelAndView listOfProducts() {
		List<Products> products = productServiceRestProxy.retrieveProducts(); // invoking another microservice - the rest service 
		
		for(Products p:products) {
			List<Categories> cats = categoryServiceRestProxy.retrieveCategoryByProduct(p.getId());
			p.setCategories(cats);
		}
		
		//products.forEach(e-> System.out.println(e));
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-products"); // logical name
		modelAndView.addObject("products",products);
		return modelAndView;
	}
	
	@GetMapping(path = "/products/showFormForAdd")
	public ModelAndView showFormForAddProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product-form"); // logical name
		Products theProduct = new Products();
		modelAndView.addObject("product",theProduct);
		return modelAndView;
	}
	
	@GetMapping(path = "/products/showFormForUpdate")
	public ModelAndView showFormForUpdateProduct(@ModelAttribute("productId") Integer theId ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product-form"); // logical name
		Products theProduct = productServiceRestProxy.retrieveProduct(theId);
		modelAndView.addObject("product",theProduct);
		productServiceRestProxy.updateProduct(theId, theProduct);
		return modelAndView;
	}
	
	@PostMapping(path="/products/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Products theProduct) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/products/list"); // logical name
		productServiceRestProxy.createProducts(theProduct);
		return modelAndView;
	}
	
	@GetMapping(path="/products/delete")
	public ModelAndView deleteProduct(@ModelAttribute("productId") Integer theId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/products/list"); // logical name
		productServiceRestProxy.deleteProduct(theId);
		return modelAndView;
	}
}

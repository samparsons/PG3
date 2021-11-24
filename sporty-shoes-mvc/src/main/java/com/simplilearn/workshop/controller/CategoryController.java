package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.proxy.ProductServiceRestProxy;
import com.simplilearn.workshop.proxy.CategoryServiceRestProxy;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceRestProxy categoryServiceRestProxy;
	
	@Autowired
	private ProductServiceRestProxy productServiceRestProxy;
	
	@GetMapping(path = "/categories/list")
	public ModelAndView listOfCategories() {
		List<Categories> categories = categoryServiceRestProxy.retrieveCategories(); // invoking another microservice - the rest service 
		categories.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-categories"); // logical name
		modelAndView.addObject("categories",categories);
		return modelAndView;
	}
	
	@GetMapping(path = "/categories/showFormForAdd")
	public ModelAndView showFormForAddCategory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category-form"); // logical name
		Categories theCategory = new Categories();
		modelAndView.addObject("category",theCategory);
		return modelAndView;
	}
	
	@GetMapping(path = "/categories/showFormForUpdate")
	public ModelAndView showFormForUpdateCategory(@ModelAttribute("categoryId") Integer theId ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category-form"); // logical name
		Categories theCategory = categoryServiceRestProxy.retrieveCategory(theId);
		modelAndView.addObject("category",theCategory);
		categoryServiceRestProxy.updateCategory(theId, theCategory);
		return modelAndView;
	}
	
	@PostMapping(path="/categories/saveCategory")
	public ModelAndView saveCategory(@ModelAttribute("category") Categories theCategory) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/categories/list"); // logical name
		categoryServiceRestProxy.createCategories(theCategory);
		return modelAndView;
	}
	
	@GetMapping(path="/categories/delete")
	public ModelAndView deleteCategory(@ModelAttribute("categoryId") Integer theId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/categories/list"); // logical name
		categoryServiceRestProxy.deleteCategory(theId);
		return modelAndView;
	}
}

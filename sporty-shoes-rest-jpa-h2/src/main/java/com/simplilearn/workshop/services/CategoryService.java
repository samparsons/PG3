package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Categories;

public interface CategoryService {
	
	
	public List<Categories> getCategories();
	public List<Categories> getCategoriesByProduct(Integer theId);
	public Categories saveCategory(Categories theCategory);
	public Categories getCategory(Integer theId);
	//public List<Categories> findByCategory(String category);
	public void deleteCategory(Integer theId);
	

}

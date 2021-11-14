package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Categories;
import com.simplilearn.workshop.repository.CategoryRepository;

@Service(value="categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	@Override
	public List<Categories> getCategoriesByProduct(Integer theId) {
		// TODO Auto-generated method stub
		return categoryRepository.findAllByProduct(theId);
	}

	@Override
	public Categories saveCategory(Categories theCategory) {
		// TODO Auto-generated method stub
		return categoryRepository.save(theCategory);
	}

	@Override
	public Categories getCategory(Integer theId) {
		// TODO Auto-generated method stub
		return categoryRepository.getById(theId);
	}

	@Override
	public void deleteCategory(Integer theId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(theId);
	}
	
	/*
	 * @Override public List<Categories> findByCategory(String category) { // TODO
	 * Auto-generated method stub return
	 * categoryRepository.findByCategory(category); }
	 */

}

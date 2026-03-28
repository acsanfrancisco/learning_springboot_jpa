package com.acsanfrancisco.firstspringproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsanfrancisco.firstspringproject.entities.Category;
import com.acsanfrancisco.firstspringproject.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		List<Category> listCategory = categoryRepository.findAll();
		return listCategory;
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		return optionalCategory.get();
	}

}

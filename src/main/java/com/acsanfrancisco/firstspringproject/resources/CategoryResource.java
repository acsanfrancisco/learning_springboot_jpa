package com.acsanfrancisco.firstspringproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsanfrancisco.firstspringproject.entities.Category;
import com.acsanfrancisco.firstspringproject.services.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>>findAll(){
		List<Category> findAll = categoryService.findAll();
		return ResponseEntity.ok().body(findAll);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category findById = categoryService.findById(id);
		return ResponseEntity.ok().body(findById);
	}
}

package com.acsanfrancisco.firstspringproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsanfrancisco.firstspringproject.entities.Product;
import com.acsanfrancisco.firstspringproject.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		List<Product> findAll = productRepository.findAll();
		return findAll;
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.get();
	}
}

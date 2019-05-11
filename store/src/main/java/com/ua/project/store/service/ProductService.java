package com.ua.project.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.ProductRepository;
import com.ua.project.store.domain.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}
}

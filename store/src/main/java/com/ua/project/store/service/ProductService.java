package com.ua.project.store.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.ProductRepository;
import com.ua.project.store.domain.Product;

@Service
public class ProductService {

	private Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		logger.info("Save product to DB " + product.toString());
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		logger.info("Get all product items");
		return productRepository.findAll();
	}
	
	public Product findById(Integer id) {
		logger.info("Find product by id " + id);
		return productRepository.findById(id).get();
	}
}

package com.ua.project.store.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.ua.project.store.domain.Product;

public class ProductDTOHelper {

	public static Product createEntity(MultipartFile file, String name, String description, Double price,
			String title) throws IOException {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setTitle(title);
		product.setPrice(price);
		product.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return product;
	}
}

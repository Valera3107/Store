package com.ua.project.store.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ua.project.store.domain.Product;
import com.ua.project.store.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView createPeriodical(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String description, @RequestParam Double price, @RequestParam String title)
			throws IOException {
		productService.save(ProductDTOHelper.createEntity(image, name, description, price, title));
		return new ModelAndView("redirect:/home");
	}
}

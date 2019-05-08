package com.ua.project.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ua.project.store.domain.Product;
import com.ua.project.store.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView createPeriodical(@Valid @ModelAttribute("product") Product product, BindingResult bind) {
		productService.save(product);
		return new ModelAndView("redirect:/home");
	}
}

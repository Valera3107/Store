package com.ua.project.store.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ua.project.store.domain.Bucket;
import com.ua.project.store.domain.Product;
import com.ua.project.store.domain.User;
import com.ua.project.store.service.BucketService;
import com.ua.project.store.service.ProductService;
import com.ua.project.store.service.UserService;

@Controller
public class BucketController {
	
	@Autowired
	private BucketService bucketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/buckets", method = RequestMethod.GET)
	public ModelAndView getAllBuckets() {
		return getBucketItems();
	}
	
	@RequestMapping(value = "/bucket", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String productId) {
		Product product = productService.findById(Integer.parseInt(productId));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		User user = userService.getByLogin(login);
	
		Bucket bucket = new Bucket();
		bucket.setProduct(product);
		bucket.setPurchaseDate(new Date());
		bucket.setUser(user);

		bucketService.bucketAdd(bucket);
		return getBucketItems();
	}
	
	@RequestMapping(value = "/bucket", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s",""))));
		return getBucketItems();
	}
	
	private ModelAndView getBucketItems() {
		ModelAndView mav = new ModelAndView("bucket");
		mav.addObject("buckets", bucketService.getAll());
		return mav;
	}
}

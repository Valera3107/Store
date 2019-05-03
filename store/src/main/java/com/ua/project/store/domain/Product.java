package com.ua.project.store.domain;

public class Product {
	private Integer id;
	private String title;
	private String name;
	private String description;
	private Double price;

	public Product() {
	}

	public Product(String title, String name, String description, Double price) {
		this.title = title;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product(Integer id, String title, String name, String description, Double price) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

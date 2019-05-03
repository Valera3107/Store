package com.ua.project.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.project.store.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

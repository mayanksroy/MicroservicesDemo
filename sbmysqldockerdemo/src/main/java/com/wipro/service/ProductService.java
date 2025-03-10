package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Product;
import com.wipro.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository prodRepository;

	public Product saveProduct(Product product) {
		return prodRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return prodRepository.findAll();
	}
}

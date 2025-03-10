package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Product;
import com.wipro.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	public ProductService prodService;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product)
	{
		return prodService.saveProduct(product);
	}
	
	@GetMapping("/getall")
	public List<Product> getAllProducts()
	{
		return prodService.getAllProducts();
	}
}

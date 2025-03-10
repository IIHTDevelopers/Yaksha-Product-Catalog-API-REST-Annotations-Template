package com.yaksha.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.dto.Product;
import com.yaksha.assignment.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Get product by ID
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.getProductById(id);
	}

	// Get all products
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Create a new product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	// Update product
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	// Delete product by ID
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
}

package com.yaksha.assignment.service;

import com.yaksha.assignment.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Adding sample data
        products.add(new Product(1, "iPhone 12", 799.99, "Smartphones"));
        products.add(new Product(2, "MacBook Pro", 1299.99, "Laptops"));
    }

    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setCategory(product.getCategory());
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}

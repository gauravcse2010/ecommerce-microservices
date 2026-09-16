package com.ecommerce.product_service.service;

import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.exception.ProductNotFoundException;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a single product by ID
    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    // Create a new product (all fields optional via DTO pattern)
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product (partial update - only set provided fields)
    public Product updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategoryId(product.getCategoryId());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setSku(product.getSku());
        existingProduct.setStatus(product.getStatus());

        return productRepository.save(existingProduct);
    }

    // Delete a product by ID
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }
}

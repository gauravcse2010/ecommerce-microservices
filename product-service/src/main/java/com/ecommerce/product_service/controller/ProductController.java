package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET /api/products - Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // GET /api/products/{id} - Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // POST /api/products - Add new product (only name and description required)
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestParam(required = false, defaultValue = "1") int categoryId,
            @RequestBody(required = false) Product product) {
        if (product != null && !product.getName().isEmpty() && !product.getDescription().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // PUT /api/products/{id} - Update product (all fields optional, only name/description required)
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // DELETE /api/products/{id} - Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

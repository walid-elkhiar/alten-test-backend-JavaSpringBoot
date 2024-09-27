package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.controller;

import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.entitie.Product;
import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> allProducts() {
        return productService.getAllProducts();

    }

    @GetMapping("/products/{productId}")
    public Product getOneProduct(@PathVariable("productId") Long productId) {
        return productService.getProduct(productId);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    @DeleteMapping("/products")
    public String deleteAllProducts() {
        return productService.deleteAllProducts();
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updatedProduct);
    }
    @PatchMapping("/products/{productId}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long productId, @RequestBody Product product) {
        Product updatedProduct = productService.patchProduct(productId, product);
        return ResponseEntity.ok(updatedProduct);
    }

}

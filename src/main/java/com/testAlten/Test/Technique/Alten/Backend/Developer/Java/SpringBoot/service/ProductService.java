package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.service;

import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.entitie.Product;

import java.util.List;

public interface ProductService {
    public String createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    public String deleteProduct(Long productId);
    public String deleteAllProducts();

    public Product getProduct(Long productId);
    public List<Product> getAllProducts();
    public Product patchProduct(Long productId, Product product);
}

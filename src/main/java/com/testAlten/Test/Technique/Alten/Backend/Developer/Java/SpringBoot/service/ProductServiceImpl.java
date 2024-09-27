package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.service;

import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.entitie.Product;
import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.exception.ProductNotFoundException;
import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.repositorie.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product created successfully";
    }


    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            existingProduct.setCode(product.getCode());
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setImage(product.getImage());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setInternalReference(product.getInternalReference());
            existingProduct.setShellId(product.getShellId());
            existingProduct.setInventoryStatus(product.getInventoryStatus());
            existingProduct.setRating(product.getRating());
            existingProduct.setCreatedAt(product.getCreatedAt());
            existingProduct.setUpdatedAt(System.currentTimeMillis());

            return productRepository.save(existingProduct); // Enregistrez le produit mis à jour
        } else {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
    }

    @Override
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product Deleted successfully";
    }

    @Override
    public String deleteAllProducts() {
         productRepository.deleteAll();
        return "All products deleted successfully";
    }

    @Override
    public Product getProduct(Long productId) {
        if (productRepository.findById(productId).isEmpty())
            throw new ProductNotFoundException("Requested Product does not exist");
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product patchProduct(Long productId, Product product) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            if (product.getCode() != null) {
                existingProduct.setCode(product.getCode());
            }
            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }
            if (product.getDescription() != null) {
                existingProduct.setDescription(product.getDescription());
            }
            if (product.getImage() != null) {
                existingProduct.setImage(product.getImage());
            }
            if (product.getCategory() != null) {
                existingProduct.setCategory(product.getCategory());
            }
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            if (product.getQuantity() != null) {
                existingProduct.setQuantity(product.getQuantity());
            }
            if (product.getInternalReference() != null) {
                existingProduct.setInternalReference(product.getInternalReference());
            }
            if (product.getShellId() != null) {
                existingProduct.setShellId(product.getShellId());
            }
            if (product.getInventoryStatus() != null) {
                existingProduct.setInventoryStatus(product.getInventoryStatus());
            }
            if (product.getRating() != null) {
                existingProduct.setRating(product.getRating());
            }
            existingProduct.setUpdatedAt(System.currentTimeMillis());

            return productRepository.save(existingProduct);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
    }
}

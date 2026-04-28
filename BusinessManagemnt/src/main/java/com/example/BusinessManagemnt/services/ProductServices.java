package com.example.BusinessManagemnt.services;

import com.example.BusinessManagemnt.entities.Product;
import com.example.BusinessManagemnt.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    // Add Product
    public void addProduct(Product p) {
        productRepository.save(p);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();  // ✅ no casting
    }

    // Get single product
    public Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update product
    public void updateProduct(Product p, int id) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setPname(p.getPname());
        existing.setPprice(p.getPprice());
        existing.setPdescription(p.getPdescription());

        productRepository.save(existing);
    }

    // Delete product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    // Get product by name
    public Product getProductByName(String name) {
        return productRepository.findByPname(name);
    }
}
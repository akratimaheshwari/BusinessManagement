package com.example.BusinessManagemnt.controllers;

import com.example.BusinessManagemnt.entities.Product;
import com.example.BusinessManagemnt.services.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductServices productServices;

    // Add Product
    @PostMapping("/addingProduct")
    public String addProduct(@ModelAttribute Product product) {
        productServices.addProduct(product);
        return "redirect:/admin/services";
    }

    // Update Product
    @GetMapping("/updatingProduct/{productId}")
    public String updateProduct(@ModelAttribute Product product,
                                @PathVariable("productId") int id) {

        productServices.updateProduct(product, id);
        return "redirect:/admin/services";
    }

    // Delete Product
    @GetMapping("/deleteProduct/{productId}")
    public String delete(@PathVariable("productId") int id) {
        productServices.deleteProduct(id);
        return "redirect:/admin/services";
    }
}
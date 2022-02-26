package com.webapp.controller;

import com.webapp.entity.Product;
import com.webapp.exception.ResourceNotFoundException;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/spring")
public class RestApiController {
    @Autowired
    ProductService service;

    @GetMapping(path = "/product")
    public List<Product> getAll() {
        return service.getProducts();
    }

    @GetMapping(path = "/product/{productId}")
    public Product getProduct(@PathVariable String productId) {
        Product product = service.getProductById(productId);
        if (product == null)
            throw new ResourceNotFoundException(String.format("Given Product ID %s not found", productId));
        return product;
    }

    @PostMapping(path = "/product")
    public Product createProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @DeleteMapping(path = "/product/{productId}")
    public Product deleteProduct(@PathVariable String productId) {
        Product product = service.getProductById(productId);
        if (product == null)
            throw new ResourceNotFoundException(String.format("Given Product ID %s not found", productId));
        service.deleteProduct(product);
        return product;
    }
}

package com.webapp.service;

import com.webapp.entity.Product;
import com.webapp.exception.ErrorResponse;
import com.webapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(String productId)  {
        return repo.findById(productId).orElse(null);
    }

    public void deleteProduct(Product product) {
        repo.delete(product);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }
}

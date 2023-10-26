package com.restapi.services;

import com.restapi.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    void updateProduct(Long id,Product product);

    void deleteProductById(Long id);
}

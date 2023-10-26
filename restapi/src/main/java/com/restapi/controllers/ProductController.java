package com.restapi.controllers;


import com.restapi.controllers.exceptions.ProductNotFoundException;
import com.restapi.models.Product;
import com.restapi.services.impl.ProductOrderServiceImpl;
import com.restapi.services.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Продукты", description = "Схема управления продуктами")
public class ProductController {
    private final ProductServiceImpl productService;
    private final ProductOrderServiceImpl productOrderService;

    @Autowired
    public ProductController(ProductServiceImpl productService, ProductOrderServiceImpl productOrderService) {
        this.productService = productService;
        this.productOrderService = productOrderService;
    }

    @GetMapping()
    @Operation(
            summary = "Вывод всех продуктов",
            description = "Вывод всех продуктов"
    )
    public List<Product> all() {
        return productService.getAllProducts();
    }


    @PostMapping("/new")
    @Operation(
            summary = "Создание нового продукта",
            description = "Создание нового продукта с его описанием, ценой"
    )
    public Product newProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @GetMapping("/item/{id}")
    @Operation(
            summary = "Вывод информации о продукте",
            description = "Вывод информации о продукте"
    )
    public Product show(@PathVariable("id") Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }


    @PutMapping("update/{id}")
    @Operation(
            summary = "Обновление данных продукта",
            description = "Обновление данных продукта"
    )
    public Product update(@RequestBody Product updatedProduct, @PathVariable("id") Long id) {
        return productService.getProductById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setDescription(updatedProduct.getDescription());
                    return productService.createProduct(product);
                })
                .orElseGet(() -> {
                    updatedProduct.setId(id);
                    return productService.createProduct(updatedProduct);
                });
    }


    @DeleteMapping("delete/{id}")
    @Operation(
            summary = "Удаление продукта",
            description = "Удаление продукта"
    )
    public void delete(@PathVariable("id") Long id) {
        productOrderService.deleteOrder(id);
        productService.deleteProductById(id);
    }
}

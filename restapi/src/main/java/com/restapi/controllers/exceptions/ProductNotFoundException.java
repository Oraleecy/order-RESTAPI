package com.restapi.controllers.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("could not find product " + id);
    }
}

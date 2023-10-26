package com.restapi.controllers.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("could not found " + id);
    }

}

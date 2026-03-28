package com.shopwave.exception;

// Name: Yared Kiros
// ID: ATE/7702/14

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
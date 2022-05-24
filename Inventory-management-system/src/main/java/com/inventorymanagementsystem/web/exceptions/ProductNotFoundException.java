package com.inventorymanagementsystem.web.exceptions;

public class ProductNotFoundException extends Throwable{

    public ProductNotFoundException(String message) {
        super(message);
    }
}

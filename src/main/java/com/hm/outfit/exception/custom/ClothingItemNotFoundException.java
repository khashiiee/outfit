package com.hm.outfit.exception.custom;

public class ClothingItemNotFoundException extends RuntimeException {
    public ClothingItemNotFoundException(String message) {
        super(message);
    }
}

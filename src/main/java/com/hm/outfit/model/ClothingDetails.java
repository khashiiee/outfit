package com.hm.outfit.model;

public record ClothingDetails(
        String pattern,
        String length,
        String sleeves,
        String neckline,
        String closure,
        String fabric
) {}
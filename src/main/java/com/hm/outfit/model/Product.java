package com.hm.outfit.model;

import java.math.BigDecimal;
import java.util.Set;

public interface Product {
    String getName();
    void setName(String name);

    BigDecimal getPrice();
    void setPrice(BigDecimal price);

    boolean isInStock();
    void setInStock(boolean inStock);

    String getBrand();
    void setBrand(String brand);

    Set<ProductImage> getProductImages();
    void setProductImages(Set<ProductImage> productImages);

    MainCategory getMainCategory();
    void setMainCategory(MainCategory mainCategory);
}
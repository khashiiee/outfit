package com.hm.outfit.model;


import com.azure.spring.data.cosmos.core.mapping.Container;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Container(containerName = "clothingItems")
public class ClothingItem implements Product {
    @Id
    @NotNull
    private String id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private String brand;
    private Set<ProductImage> productImages;
    private MainCategory mainCategory;

    private Set<Color> colors;
    private Set<Season> suitableSeasons;
    private ClothingCategory clothingCategory;
    private Set<Size> availableSizes;
    private ClothingStyle style;
    private ClothingDetails details;

    public ClothingItem(String id, String name, BigDecimal price, boolean inStock, String brand,
                        Set<ProductImage> productImages, MainCategory mainCategory, Set<Color> colors,
                        Set<Season> suitableSeasons, ClothingCategory clothingCategory, Set<Size> availableSizes,
                        ClothingStyle style, ClothingDetails details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.brand = brand;
        this.productImages = productImages;
        this.mainCategory = mainCategory;
        this.colors = colors;
        this.suitableSeasons = suitableSeasons;
        this.clothingCategory = clothingCategory;
        this.availableSizes = availableSizes;
        this.style = style;
        this.details = details;
    }
}
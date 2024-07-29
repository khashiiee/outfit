package com.hm.outfit.model;


import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.Set;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "clothingItems")
public class ClothingItem {

    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private Set<Color> colors;
    private Set<Season> suitableSeasons;
    private ClothingCategory clothingCategory;
    private Set<Size> availableSizes;
    private String brand;
    private ClothingStyle style;
    private Set<ProductImage> productImage;
    private MainCategory mainCategory;
    private ClothingDetails details;

}
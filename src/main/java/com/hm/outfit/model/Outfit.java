package com.hm.outfit.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Outfit {
    private String id;
    private List<ClothingItem> items;
    private OutfitTemplate template;
    private BigDecimal totalCost;
    private Season season;

}

package com.hm.outfit.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OutfitTemplate {

    private String id;
    private String name;
    private List<ClothingCategory> requiredCategories;
    private List<ClothingCategory> optionalCategories;
    private int minItems;
    private int maxItems;

    public <T> OutfitTemplate(String topAndBottom, String topAndBottomOutfit, List<ClothingCategory> requiredCategories, List<ClothingCategory> optionalCategories, int i, int i1) {
        this.id = topAndBottom;
        this.name = topAndBottomOutfit;
        this.requiredCategories = requiredCategories;
        this.optionalCategories = optionalCategories;
        this.minItems = i;
        this.maxItems = i;
    }

    public boolean isValidOutfit(List<ClothingItem> items) {
        if (items.size() < minItems || items.size() > maxItems) {
            return false;
        }

        // Check if all required categories are present
        for (ClothingCategory requiredCategory : requiredCategories) {
            if (items.stream().noneMatch(item -> item.getClothingCategory() == requiredCategory)) {
                return false;
            }
        }

        // Check if all items belong to either required or optional categories
        for (ClothingItem item : items) {
            if (!requiredCategories.contains(item.getClothingCategory()) &&
                    !optionalCategories.contains(item.getClothingCategory())) {
                return false;
            }
        }

        return true;
    }

}


package com.hm.outfit.service;

import com.hm.outfit.exception.custom.ClothingItemNotFoundException;
import com.hm.outfit.model.ClothingCategory;
import com.hm.outfit.model.ClothingItem;
import com.hm.outfit.model.Season;
import com.hm.outfit.model.Size;
import com.hm.outfit.repository.ClothingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ClothingItemService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    public ClothingItem getClothingItemById(String itemId) {
        return clothingItemRepository.findById(itemId)
                .orElseThrow(() -> new ClothingItemNotFoundException("Clothing item not found with id: " + itemId));
    }

    public ClothingItem createClothingItem(ClothingItem item) {
        return clothingItemRepository.save(item);
    }

    public List<ClothingItem> getAllClothingItems() {
        Iterable<ClothingItem> itemsIterable = clothingItemRepository.findAll();
        List<ClothingItem> itemsList = new ArrayList<>();
        itemsIterable.forEach(itemsList::add);
        return itemsList;
    }

    public ClothingItem updateClothingItem(String itemId, ClothingItem updatedItem) {
        ClothingItem existingItem = getClothingItemById(itemId);
        // Update clothing item fields here
        return clothingItemRepository.save(existingItem);
    }

    public void deleteClothingItem(String itemId) {
        ClothingItem item = getClothingItemById(itemId);
        clothingItemRepository.delete(item);
    }

    public List<ClothingItem> getClothingItemsByCategory(ClothingCategory category) {
        return clothingItemRepository.findByClothingCategory(category);
    }

    public List<ClothingItem> getClothingItemsByCategoryAndSizes(ClothingCategory category, Set<Size> sizes) {
        return clothingItemRepository.findByClothingCategoryAndAvailableSizesIn(category, Collections.singleton(sizes));
    }

//    public List<ClothingItem> getClothingItemsByColors(Set<String> colors) {
//        return clothingItemRepository.findByColorsIn(colors);
//    }

    public List<ClothingItem> getClothingItemsBySeason(Season season) {
        return clothingItemRepository.findBySuitableSeasonsContaining(season);
    }

    public List<ClothingItem> getClothingItemsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return clothingItemRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
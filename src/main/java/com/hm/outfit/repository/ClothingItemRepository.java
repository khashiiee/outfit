package com.hm.outfit.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.hm.outfit.model.ClothingCategory;
import com.hm.outfit.model.ClothingItem;
import com.hm.outfit.model.Season;
import com.hm.outfit.model.Size;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ClothingItemRepository  extends CosmosRepository<ClothingItem, String> {
    List<ClothingItem> findByClothingCategory(ClothingCategory category);
    List<ClothingItem> findByClothingCategoryAndAvailableSizesIn(ClothingCategory clothingCategory, Collection<Set<Size>> availableSizes);
    //    List<ClothingItem> findByColorsIn(Set<String> colors);
    List<ClothingItem> findBySuitableSeasonsContaining(Season season);
    List<ClothingItem> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
//    Iterable<ClothingItem> findAll();

}

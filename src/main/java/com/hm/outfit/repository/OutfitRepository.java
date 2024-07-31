package com.hm.outfit.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.hm.outfit.model.ClothingCategory;
import com.hm.outfit.model.Outfit;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OutfitRepository extends CosmosRepository<Outfit, String> {
    Optional<Outfit> findById(String id);
    List<Outfit> findByTotalCostLessThanEqual(BigDecimal maxCost);
    // Add more query methods as needed
}

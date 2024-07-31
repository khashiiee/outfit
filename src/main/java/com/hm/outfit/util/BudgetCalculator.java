package com.hm.outfit.util;

import org.springframework.stereotype.Component;

import com.hm.outfit.model.Outfit;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BudgetCalculator {

    public BigDecimal calculateOutfitCost(Outfit outfit) {
        return outfit.getItems().stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Outfit> filterByBudget(List<Outfit> outfits, BigDecimal budget) {
        return outfits.stream()
                .filter(outfit -> {
                    BigDecimal cost = calculateOutfitCost(outfit);
                    return cost.compareTo(budget) <= 0;
                })
                .collect(Collectors.toList());
    }

    public List<Outfit> optimizeForBudget(List<Outfit> outfits, BigDecimal budget) {
        List<Outfit> affordableOutfits = filterByBudget(outfits, budget);

        // Sort outfits by their price-to-item ratio (more items for the price is better)
        affordableOutfits.sort((o1, o2) -> {
            BigDecimal ratio1 = calculateOutfitCost(o1).divide(BigDecimal.valueOf(o1.getItems().size()), 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal ratio2 = calculateOutfitCost(o2).divide(BigDecimal.valueOf(o2.getItems().size()), 2, BigDecimal.ROUND_HALF_UP);
            return ratio1.compareTo(ratio2);
        });

        return affordableOutfits;
    }
}
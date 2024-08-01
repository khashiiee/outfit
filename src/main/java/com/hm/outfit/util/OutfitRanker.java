package com.hm.outfit.util;

import com.hm.outfit.model.*;
import com.hm.outfit.service.OutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class OutfitRanker {

    @Autowired
    private OutfitService outfitService;


    private static final double STYLE_WEIGHT = 0.10;
    private static final double COLOR_WEIGHT = 0.05;
    private static final double EVENT_WEIGHT = 0.15;
    private static final double SEASON_WEIGHT = 0.10;
//    private static final double SIZE_WEIGHT = 0.10;
    private static final double PRICE_WEIGHT = 0.05;
    private static final double BRAND_WEIGHT = 0.05;
    private static final double DIVERSITY_WEIGHT = 0.05;
    private static final double RATING_WEIGHT = 0.25; // New weight for user ratings
    private static final double BUDGET_FIT_WEIGHT = 0.20;

    public List<OutfitScore> rankOutfits(List<Outfit> outfits, User user, Event event, BigDecimal budget) {
        return outfits.stream()
                .map(outfit -> new OutfitScore(outfit, calculateScore(outfit, user, event, budget)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }


    private double calculateScore(Outfit outfit, User user, Event event, BigDecimal budget) {
        double score = 0.0;

        score += calculateStyleScore(outfit, user) * STYLE_WEIGHT;
        score += calculateColorScore(outfit, event) * COLOR_WEIGHT;
        score += calculateEventScore(outfit, event) * EVENT_WEIGHT;
        score += calculateSeasonScore(outfit, event) * SEASON_WEIGHT;
//        score += calculateSizeScore(outfit, user) * SIZE_WEIGHT;
        score += calculatePriceScore(outfit, budget) * PRICE_WEIGHT;
        score += calculateBrandScore(outfit, user) * BRAND_WEIGHT;
        score += calculateDiversityScore(outfit) * DIVERSITY_WEIGHT;
        score += calculateRatingScore(outfit, user) * RATING_WEIGHT; // user rating score
        score += calculateBudgetFitScore(outfit, budget) * BUDGET_FIT_WEIGHT; // New budget fit score


        return score;
    }

    private double calculateStyleScore(Outfit outfit, User user) {
        long matchingStyles = outfit.getItems().stream()
                .filter(item -> user.getPreferredStyles().contains(item.getStyle()))
                .count();
        return (double) matchingStyles / outfit.getItems().size();
    }

    private double calculateColorScore(Outfit outfit, Event event) {
        Set<Color> eventColors = event.getSuitableColors();
        long matchingColors = outfit.getItems().stream()
                .flatMap(item -> item.getColors().stream())
                .filter(eventColors::contains)
                .count();
        return (double) matchingColors / outfit.getItems().size();
    }

    private double calculateEventScore(Outfit outfit, Event event) {
        return outfit.getItems().stream()
                .filter(item -> item.getStyle() == event.getPreferredStyle())
                .count() / (double) outfit.getItems().size();
    }

    private double calculateSeasonScore(Outfit outfit, Event event) {
        return outfit.getItems().stream()
                .filter(item -> item.getSuitableSeasons().contains(event.getSeason()))
                .count() / (double) outfit.getItems().size();
    }

//    private double calculateSizeScore(Outfit outfit, User user) {
//        return outfit.getItems().stream()
//                .filter(item -> item.getAvailableSizes().contains(user.getPreferredSizes()))
//                .count() / (double) outfit.getItems().size();
//    }

    private double calculatePriceScore(Outfit outfit, BigDecimal budget) {
        if (budget == null || budget.compareTo(BigDecimal.ZERO) <= 0) {
            return 1.0; // If no budget is set, don't penalize
        }
        return Math.max(0, 1 - outfit.getTotalCost().divide(budget, 2, RoundingMode.HALF_UP).doubleValue());
    }

    private double calculateBrandScore(Outfit outfit, User user) {
        // Assuming user has a preferredBrands field
        Set<String> preferredBrands = user.getPreferredBrands();
        if (preferredBrands == null || preferredBrands.isEmpty()) {
            return 1.0; // If no brand preference, don't penalize
        }
        return outfit.getItems().stream()
                .filter(item -> preferredBrands.contains(item.getBrand()))
                .count() / (double) outfit.getItems().size();
    }

    private double calculateDiversityScore(Outfit outfit) {
        // This would require keeping track of previously recommended outfits
        // For simplicity, we're returning a constant value here
        return 1.0;
    }

    private double calculateRatingScore(Outfit outfit, User user) {
        if (user.getOutfitRatings() == null || user.getOutfitRatings().isEmpty()) {
            return 0.5; // Neutral score if no ratings
        }

        // Calculate similarity between current outfit and rated outfits
        double totalSimilarity = 0;
        double totalWeightedRating = 0;

        for (Map.Entry<String, OutfitRating> entry : user.getOutfitRatings().entrySet()) {
            Outfit ratedOutfit = getOutfitById(entry.getKey());
            double similarity = calculateOutfitSimilarity(outfit, ratedOutfit);
            double rating = entry.getValue().getRating() / 5.0; // Normalize rating to 0-1 range

            totalSimilarity += similarity;
            totalWeightedRating += similarity * rating;
        }

        return totalSimilarity > 0 ? totalWeightedRating / totalSimilarity : 0.5;
    }

    private double calculateOutfitSimilarity(Outfit outfit1, Outfit outfit2) {
        // Implement similarity calculation between outfits
        // This could be based on common items, styles, colors, etc.
        // For simplicity, let's use a placeholder implementation
        return 0.5; // Placeholder: 50% similarity
    }

    private Outfit getOutfitById(String outfitId) {
        return outfitService.getOutfitById(outfitId);
    }

    private double calculateBudgetFitScore(Outfit outfit, BigDecimal budget) {
        if (budget == null || budget.compareTo(BigDecimal.ZERO) <= 0) {
            return 1.0; // If no budget is set, don't penalize
        }

        BigDecimal outfitCost = outfit.getTotalCost();
        BigDecimal difference = outfitCost.subtract(budget).abs();

        // Calculate the percentage difference
        double percentageDifference = difference.divide(budget, 4, RoundingMode.HALF_UP).doubleValue();

        // Convert to a score where 0% difference = 1.0, and larger differences approach 0
        return Math.max(0, 1 - percentageDifference);
    }
}
package com.hm.outfit.service;


import com.hm.outfit.model.*;
import com.hm.outfit.repository.ClothingItemRepository;
import com.hm.outfit.util.BudgetCalculator;
import com.hm.outfit.util.OutfitGenerator;
import com.hm.outfit.util.OutfitRanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    @Autowired
    private ClothingItemService clothingItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private OutfitGenerator outfitGenerator;

    @Autowired
    private OutfitRanker outfitRanker;

    @Autowired
    private BudgetCalculator budgetCalculator;

    public RecommendationResponse generateRecommendations(RecommendationRequest request) {
        User user = userService.getUserById(request.getUserId());
        Event event = eventService.getEventById(request.getEventId());

        Season targetSeason = request.getSeason(); // Replace with the desired season

        List<ClothingItem> suitableItems = clothingItemService.getAllClothingItems().stream()
                .filter(item -> item.getSuitableSeasons().contains(targetSeason))
                .collect(Collectors.toList());

        List<Outfit> generatedOutfits = outfitGenerator.generateOutfits(suitableItems, event, user);

        List<OutfitScore> rankedOutfits = outfitRanker.rankOutfits(generatedOutfits, user, event, request.getBudget());

        List<Outfit> recommendedOutfits = selectTopOutfits(rankedOutfits, 10);  // Assuming we want top 5

        List<Outfit> affordableOutfits = recommendedOutfits.stream()
                .filter(outfit -> outfit.getTotalCost().compareTo(request.getBudget()) <= 0)
                .collect(Collectors.toList());

        List<Outfit> expensiveYetGoodOutfits = generatedOutfits.stream()
                .filter(outfit -> outfit.getTotalCost().compareTo(request.getBudget()) > 0 &&
                        outfit.getTotalCost().compareTo(request.getBudget().multiply(new BigDecimal(2))) <= 0)
                .collect(Collectors.toList());

        boolean allExceedBudget = recommendedOutfits.stream()
                .allMatch(recommendedOutfit -> recommendedOutfit.getTotalCost().compareTo(request.getBudget()) > 0);


        return new RecommendationResponse(recommendedOutfits, request.getUserId(), request.getEventId(),allExceedBudget, affordableOutfits, expensiveYetGoodOutfits );
    }

    private List<Outfit> selectTopOutfits(List<OutfitScore> rankedOutfits, int count) {
        return rankedOutfits.stream()
                .limit(count)
                .map(OutfitScore::getOutfit)
                .toList();  // Using .toList() instead of .collect(Collectors.toList())
    }
}

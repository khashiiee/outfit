package com.hm.outfit.service;


import com.hm.outfit.model.*;
import com.hm.outfit.repository.ClothingItemRepository;
import com.hm.outfit.util.BudgetCalculator;
import com.hm.outfit.util.OutfitGenerator;
import com.hm.outfit.util.OutfitRanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<ClothingItem> suitableItems = clothingItemService.getAllClothingItems();
//                suitableItemsfindBySuitableSeasonsContaining(request.getSeason());
//        suitableItems = filterItemsByUserPreferences(suitableItems, user);

        List<Outfit> generatedOutfits = outfitGenerator.generateOutfits(suitableItems, event, user);
        List<Outfit> budgetFilteredOutfits = budgetCalculator.filterByBudget(generatedOutfits, request.getBudget());
        List<OutfitScore> rankedOutfits = outfitRanker.rankOutfits(budgetFilteredOutfits, user, event);

        List<Outfit> recommendedOutfits = selectTopOutfits(rankedOutfits, 5);  // Assuming we want top 5

        return new RecommendationResponse(recommendedOutfits, request.getUserId(), request.getEventId());
    }

    private List<ClothingItem> filterItemsByUserPreferences(List<ClothingItem> items, User user) {
        // Implementation to filter items based on user preferences
        // This could include filtering by size, preferred styles, etc.
        return items;  // Placeholder
    }

    private List<Outfit> selectTopOutfits(List<OutfitScore> rankedOutfits, int count) {
        // Implementation to select top N outfits from ranked list
        return rankedOutfits.stream()
                .limit(count)
                .map(OutfitScore::getOutfit)
                .collect(Collectors.toList());
    }
}

package com.hm.outfit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {
    private List<Outfit> recommendedOutfits;
    private String userId;
    private String eventId;
    private boolean budgetExceeded;
    private List<Outfit> affordableOutfits;
    private List<Outfit> expensiveYetGoodOutfits;

}
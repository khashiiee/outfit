package com.hm.outfit.cotroller;

import com.hm.outfit.model.RecommendationRequest;
import com.hm.outfit.model.RecommendationResponse;
import com.hm.outfit.service.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("outfits")
    public RecommendationResponse getRecommendations(@Valid @RequestBody RecommendationRequest request) {
        RecommendationResponse recommendationResponse = recommendationService.generateRecommendations(request);
        return recommendationResponse;
    }
}

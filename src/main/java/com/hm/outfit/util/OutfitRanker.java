package com.hm.outfit.util;


import com.hm.outfit.model.Event;
import com.hm.outfit.model.Outfit;
import com.hm.outfit.model.OutfitScore;
import com.hm.outfit.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutfitRanker {

    public List<OutfitScore> rankOutfits(List<Outfit> outfits, User user, Event event) {
        return outfits.stream()
                .map(outfit -> new OutfitScore(outfit, calculateScore(outfit, user, event)))
                .sorted()
                .collect(Collectors.toList());
    }

    private double calculateScore(Outfit outfit, User user, Event event) {
        double score = 0.0;

        // Score based on matching user's preferred styles
        score += calculateStyleScore(outfit, user);

        // Score based on color coordination
        score += calculateColorScore(outfit);

        // Score based on event suitability
        score += calculateEventScore(outfit, event);

        // Add more scoring criteria as needed

        return score;
    }

    private double calculateStyleScore(Outfit outfit, User user) {
        long matchingStyles = outfit.getItems().stream()
                .filter(item -> user.getPreferredStyles().contains(item.getStyle()))
                .count();
        return (double) matchingStyles / outfit.getItems().size() * 10; // Scale to 0-10
    }

    private double calculateColorScore(Outfit outfit) {
        // Implement color coordination scoring logic
        // This could involve checking for complementary colors, etc.
        return 5.0; // Placeholder
    }

    private double calculateEventScore(Outfit outfit, Event event) {
        // Implement event suitability scoring logic
        // This could involve checking if the outfit matches the event's formality, etc.
        return 5.0; // Placeholder
    }
}
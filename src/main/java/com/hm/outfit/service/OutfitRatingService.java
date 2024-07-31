package com.hm.outfit.service;

import com.hm.outfit.model.Outfit;
import com.hm.outfit.model.OutfitRating;
import com.hm.outfit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class OutfitRatingService {

    @Autowired
    private UserService userService;

    @Autowired
    private OutfitService outfitService;

    public void rateOutfit(String userId, String outfitId, int rating) {
        User user = userService.getUserById(userId);
        Outfit outfit = outfitService.getOutfitById(outfitId);
        if (user.getOutfitRatings() == null) {
            user.setOutfitRatings(new HashMap<>());
        }

        OutfitRating outfitRating = new OutfitRating(outfitId, rating, LocalDateTime.now());
        user.getOutfitRatings().put(outfitId, outfitRating);

        userService.updateUser(user);
    }


}

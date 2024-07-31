package com.hm.outfit.cotroller;

import com.hm.outfit.exception.custom.OutfitNotFoundException;
import com.hm.outfit.exception.custom.UserNotFoundException;
import com.hm.outfit.model.OutfitRatingRequest;
import com.hm.outfit.service.OutfitRatingService;

import com.hm.outfit.service.OutfitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/outfits")
public class OutfitRatingController {

    @Autowired
    private OutfitRatingService outfitRatingService;

    @PostMapping("/rate")
    public ResponseEntity<String> rateOutfit(@Valid @RequestBody OutfitRatingRequest request) {
        try {
            outfitRatingService.rateOutfit(request.getUserId(), request.getOutfitId(), request.getRating());
            return ResponseEntity.ok("Outfit rated successfully");
        } catch (UserNotFoundException | OutfitNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while rating the outfit");
        }
    }
}

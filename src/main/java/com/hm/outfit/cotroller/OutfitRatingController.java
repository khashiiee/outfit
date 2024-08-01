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

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/outfits")
public class OutfitRatingController {

    @Autowired
    private OutfitRatingService outfitRatingService;

    @PostMapping("/rate")
    public ResponseEntity<Map<String, String>> rateOutfit(@Valid @RequestBody OutfitRatingRequest request) {
        try {
            outfitRatingService.rateOutfit(request.getUserId(), request.getOutfitId(), request.getRating());
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("status", "OK");
            responseBody.put("message", "The request was successful.");

            return ResponseEntity.ok(responseBody);
        } catch (UserNotFoundException | OutfitNotFoundException e) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("status", "ERROR");
            errorBody.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
        } catch (Exception e) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("status", "ERROR");
            errorBody.put("message", "An error occurred while rating the outfit");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
    }
}
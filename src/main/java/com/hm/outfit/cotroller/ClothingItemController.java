package com.hm.outfit.cotroller;

import com.hm.outfit.model.ClothingItem;
import com.hm.outfit.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingItemController {

    @Autowired
    private ClothingItemService clothingItemService;

    @GetMapping
    public ResponseEntity<List<ClothingItem>> getAllClothingItems() {
        List<ClothingItem> clothingItems = clothingItemService.getAllClothingItems();
        return ResponseEntity.ok(clothingItems);
    }
}

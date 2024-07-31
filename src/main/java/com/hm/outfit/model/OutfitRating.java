package com.hm.outfit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRating {
    private String outfitId;
    private int rating; // 1 to 5
    private LocalDateTime ratedAt;
}
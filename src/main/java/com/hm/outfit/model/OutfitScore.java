package com.hm.outfit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutfitScore implements Comparable<OutfitScore> {

    private Outfit outfit;
    private double score;

    @Override
    public int compareTo(OutfitScore other) {
        return Double.compare(this.score, other.score);
    }
}

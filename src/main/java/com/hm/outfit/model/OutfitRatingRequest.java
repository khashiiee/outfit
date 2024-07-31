package com.hm.outfit.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRatingRequest {
    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "OutFit ID is required")
    private String outfitId;


    @NotNull(message = "Rate is required")
    @Positive(message = "Rating must be positive")
    private int rating;

}
package com.hm.outfit.util;

import com.hm.outfit.model.ClothingCategory;
import com.hm.outfit.model.Gender;
import com.hm.outfit.model.OutfitTemplate;

import java.util.List;
import java.util.Arrays;

public class OutfitTemplateExamples {

    public static final OutfitTemplate DRESS_BASED = new OutfitTemplate(
            "DRESS_BASED",
            "Dress-based Outfit",
            Arrays.asList(ClothingCategory.DRESS,ClothingCategory.FOOTWEAR),
            Arrays.asList(ClothingCategory.ACCESSORY,  ClothingCategory.OUTERWEAR),
            2, 5, Gender.FEMALE
    );

    public static final OutfitTemplate TOP_AND_BOTTOM_LADIES = new OutfitTemplate(
            "TOP_AND_BOTTOM",
            "Top and Bottom Outfit",
            Arrays.asList(ClothingCategory.TOP, ClothingCategory.BOTTOM),
            Arrays.asList(ClothingCategory.ACCESSORY, ClothingCategory.FOOTWEAR, ClothingCategory.OUTERWEAR),
            2, 6, Gender.FEMALE
    );


    public static final OutfitTemplate TOP_AND_BOTTOM_MALE = new OutfitTemplate(
            "TOP_AND_BOTTOM",
            "Top and Bottom Outfit",
            Arrays.asList(ClothingCategory.TOP, ClothingCategory.BOTTOM),
            Arrays.asList(ClothingCategory.ACCESSORY, ClothingCategory.FOOTWEAR, ClothingCategory.OUTERWEAR),
            2, 6, Gender.MALE
    );

    public static final OutfitTemplate FORMAL_SUIT_MALE = new OutfitTemplate(
            "FORMAL_SUIT",
            "Formal Suit Outfit",
            Arrays.asList(ClothingCategory.SUIT_JACKET, ClothingCategory.SUIT_PANTS, ClothingCategory.DRESS_SHIRT),
            Arrays.asList(ClothingCategory.TIE, ClothingCategory.FOOTWEAR, ClothingCategory.ACCESSORY),
            3, 7, Gender.FEMALE
    );

    public static final OutfitTemplate CASUAL_SUMMER_FEMALE = new OutfitTemplate(
            "CASUAL_SUMMER",
            "Casual Summer Outfit",
            Arrays.asList(ClothingCategory.TOP,ClothingCategory.SHORTS),
            Arrays.asList(ClothingCategory.FOOTWEAR, ClothingCategory.ACCESSORY),
            2, 5, Gender.FEMALE
    );

    public static final OutfitTemplate CASUAL_SUMMER_FEMALE_2 = new OutfitTemplate(
            "CASUAL_SUMMER",
            "Casual Summer Outfit",
            Arrays.asList(ClothingCategory.TOP,ClothingCategory.SHIRT),
            Arrays.asList(ClothingCategory.SKIRT, ClothingCategory.FOOTWEAR, ClothingCategory.ACCESSORY),
            2, 5, Gender.FEMALE
    );

    public static final OutfitTemplate CASUAL_SUMMER_MALE = new OutfitTemplate(
            "CASUAL_SUMMER",
            "Casual Summer Outfit",
            Arrays.asList(ClothingCategory.TOP, ClothingCategory.SHORTS),
            Arrays.asList( ClothingCategory.FOOTWEAR, ClothingCategory.ACCESSORY),
            2, 5, Gender.MALE
    );

    public static final OutfitTemplate CASUAL_SPRING_MALE = new OutfitTemplate(
            "CASUAL_SPRING",
            "Casual Spring Outfit",
            Arrays.asList(ClothingCategory.TOP, ClothingCategory.BOTTOM,ClothingCategory.OUTERWEAR),
            Arrays.asList( ClothingCategory.FOOTWEAR, ClothingCategory.ACCESSORY),
            3, 5, Gender.MALE
    );

    public static List<OutfitTemplate> getAllTemplates() {
        return Arrays.asList(DRESS_BASED, TOP_AND_BOTTOM_LADIES, TOP_AND_BOTTOM_MALE, FORMAL_SUIT_MALE,CASUAL_SUMMER_FEMALE,CASUAL_SUMMER_FEMALE_2, CASUAL_SUMMER_MALE,CASUAL_SPRING_MALE);
    }
}

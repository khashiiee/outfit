package com.hm.outfit.util;

import com.hm.outfit.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class OutfitGenerator {
    private List<OutfitTemplate> templates;

    public OutfitGenerator() {
        this.templates = OutfitTemplateExamples.getAllTemplates();
    }

    public List<Outfit> generateOutfits(List<ClothingItem> items, Event event, User user) {
        System.out.println("Starting outfit generation for user: " + user.getName());
        this.templates = this.templates.stream()
                .filter(template -> template.getGender() == user.getGender())
                .collect(Collectors.toList());
        System.out.println("Number of suitable templates: " + this.templates.size());

        List<Outfit> allOutfits = new ArrayList<>();
        for (OutfitTemplate template : this.templates) {
            List<Outfit> outfitsForTemplate = generateOutfits(items, event, user, template);
            System.out.println("Generated " + outfitsForTemplate.size() + " outfits for template: " + template.getName());
            allOutfits.addAll(outfitsForTemplate);
        }
        System.out.println("Total outfits generated: " + allOutfits.size());
        return allOutfits;
    }

    private List<Outfit> generateOutfits(List<ClothingItem> items, Event event, User user, OutfitTemplate template) {
        System.out.println("Generating outfits for template: " + template.getName());
        Map<ClothingCategory, List<ClothingItem>> suitableItemsByCategory = new HashMap<>();

        for (ClothingCategory category : template.getRequiredCategories()) {
            List<ClothingItem> suitableItems = findSuitableItems(items, category, user, event);
            System.out.println("Suitable items for " + category + ": " + suitableItems.size());
            if (suitableItems.isEmpty()) {
                System.out.println("No suitable items found for required category: " + category);
                return Collections.emptyList();
            }
            suitableItemsByCategory.put(category, suitableItems);
        }

        for (ClothingCategory category : template.getOptionalCategories()) {
            List<ClothingItem> suitableItems = findSuitableItems(items, category, user, event);
            System.out.println("Suitable items for optional " + category + ": " + suitableItems.size());
            if (!suitableItems.isEmpty()) {
                suitableItemsByCategory.put(category, suitableItems);
            }
        }

        List<Outfit> outfits = generateOutfitCombinations(suitableItemsByCategory, template);
        System.out.println("Generated " + outfits.size() + " outfit combinations");

        return outfits.stream()
                .filter(outfit -> outfit.getItems().size() >= template.getMinItems() && outfit.getItems().size() <= template.getMaxItems())
                .collect(Collectors.toList());
    }

    private List<Outfit> generateOutfitCombinations(Map<ClothingCategory, List<ClothingItem>> suitableItemsByCategory, OutfitTemplate template) {
        List<Outfit> outfits = new ArrayList<>();
        generateOutfitCombinationsRecursive(suitableItemsByCategory, template, new HashMap<>(), outfits, new ArrayList<>(template.getRequiredCategories()), 0);
        return outfits;
    }

    private void generateOutfitCombinationsRecursive(
            Map<ClothingCategory, List<ClothingItem>> suitableItemsByCategory,
            OutfitTemplate template,
            Map<ClothingCategory, ClothingItem> currentOutfit,
            List<Outfit> outfits,
            List<ClothingCategory> categories,
            int currentCategoryIndex) {

        if (currentCategoryIndex == categories.size()) {
            if (currentOutfit.size() >= template.getMinItems() && currentOutfit.size() <= template.getMaxItems()) {
                Outfit outfit = createOutfit(new ArrayList<>(currentOutfit.values()), template);
                outfits.add(outfit);
                System.out.println("Added new outfit: " + outfit.getItems().stream().map(ClothingItem::getName).collect(Collectors.joining(", ")));
            }
            return;
        }

        ClothingCategory currentCategory = categories.get(currentCategoryIndex);
        List<ClothingItem> items = suitableItemsByCategory.get(currentCategory);

        if (items != null) {
            for (ClothingItem item : items) {
                Map<ClothingCategory, ClothingItem> newOutfit = new HashMap<>(currentOutfit);
                newOutfit.put(currentCategory, item);
                generateOutfitCombinationsRecursive(suitableItemsByCategory, template, newOutfit, outfits, categories, currentCategoryIndex + 1);
            }
        }

        // If we've finished with required categories, add optional categories
        if (currentCategoryIndex == template.getRequiredCategories().size() - 1) {
            List<ClothingCategory> newCategories = new ArrayList<>(categories);
            newCategories.addAll(template.getOptionalCategories());
            generateOutfitCombinationsRecursive(suitableItemsByCategory, template, currentOutfit, outfits, newCategories, currentCategoryIndex + 1);
        }
    }

    private List<ClothingItem> findSuitableItems(List<ClothingItem> items, ClothingCategory category, User user, Event event) {
        return items.stream()
                .filter(item -> isSuitableCategory(item, category))
                .filter(item -> isSuitableForUser(item, user))
                .filter(item -> item.getAvailableSizes().contains(user.getPreferredSizes()))
                .filter(item -> isStyleSuitable(item, event))
                .collect(Collectors.toList());
    }

    private boolean isSuitableCategory(ClothingItem item, ClothingCategory category) {
        boolean suitable = item.getClothingCategory() == category;
        System.out.println("Checking category suitability for " + item.getName() + ": " + suitable);
        return suitable;
    }

    private boolean isSuitableForUser(ClothingItem item, User user) {
        List<String> categories = new ArrayList<>();
        categories.add(item.getMainCategory().code());
        String userAgeCategory = user.getAgeCategory();
        Boolean isSuitableForUser = false;

        // Check if the item is for kids
        boolean isKidsItem = categories.stream().anyMatch(cat -> cat.contains("kids"));
        System.out.println("Item " + item.getName());


        System.out.println("is a kid item: " + isKidsItem);

        // Check if the item is for adults
        boolean isAdultItem = categories.stream().anyMatch(cat ->
                cat.contains("ladies") || cat.contains("men") || cat.contains("adult"));

        System.out.println("is an adult item: " + isAdultItem);


        // Age suitability check
        if (isKidsItem && !user.isChild()) {
            isSuitableForUser = false;
        }

        if (isAdultItem && user.isChild()) {
            System.out.println(" clothItem is belong to adult and user is " + user.isChild());

            isSuitableForUser = false;
        }

        // Gender suitability check (for adult items)
        if (isAdultItem) {
            if ((categories.stream().anyMatch(cat -> cat.contains("men"))) && user.getGender() == Gender.MALE) {
                isSuitableForUser = true;
            }
            if( (categories.stream().anyMatch(cat -> cat.contains("ladies"))) && user.getGender() == Gender.FEMALE){
                isSuitableForUser = true;
            };
        }
        // If we've passed all checks, the item is suitable

        System.out.println("Finally : check age and gender : is suitable for user : " + isSuitableForUser);

        return isSuitableForUser;
    }

    private boolean isStyleSuitable(ClothingItem item, Event event) {
        boolean suitable = item.getStyle() == event.getPreferredStyle();
        System.out.println("Checking style suitability for " + item.getName() + ": " + suitable);
        return suitable;
    }


    private Outfit createOutfit(List<ClothingItem> items, OutfitTemplate template) {
        BigDecimal totalCost = calculateTotalCost(items);
        Season season = determineSeason(items);

        Outfit outfit = new Outfit();
        outfit.setId(generateOutfitId());
        outfit.setItems(items);
        outfit.setTemplate(template);
        outfit.setTotalCost(totalCost);
        outfit.setSeason(season);

        return outfit;
    }

    private String generateOutfitId() {
        // Implement a method to generate a unique ID for the outfit
        // This could be a UUID, a timestamp-based ID, or any other unique identifier
        return UUID.randomUUID().toString();
    }

    private Season determineSeason(List<ClothingItem> items) {
        // This is a simplified version. You might want to implement more sophisticated logic.
        return items.stream()
                .flatMap(item -> item.getSuitableSeasons().stream())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Season.ALL); // Default to ALL if no clear season is determined
    }


    private BigDecimal calculateTotalCost(List<ClothingItem> items) {
        return items.stream()
                .map(ClothingItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



}
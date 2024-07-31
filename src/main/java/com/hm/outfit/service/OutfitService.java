package com.hm.outfit.service;


import com.hm.outfit.exception.custom.OutfitNotFoundException;
import com.hm.outfit.model.ClothingCategory;
import com.hm.outfit.model.Outfit;
import com.hm.outfit.repository.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class OutfitService {

    @Autowired
    private OutfitRepository outfitRepository;

    public Outfit getOutfitById(String outfitId) {
        return outfitRepository.findById(outfitId)
                .orElseThrow(() -> new OutfitNotFoundException("Outfit not found with id: " + outfitId));
    }

    public List<Outfit> getAllOutfits() {
        return (List<Outfit>) outfitRepository.findAll();
    }

    public Outfit createOutfit(Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    public Outfit updateOutfit(String outfitId, Outfit updatedOutfit) {
        Outfit existingOutfit = getOutfitById(outfitId);
        // Update outfit fields here
        // For example:
        existingOutfit.setItems(updatedOutfit.getItems());
        existingOutfit.setTotalCost(updatedOutfit.getTotalCost());
        existingOutfit.setSeason(updatedOutfit.getSeason());
        // Update other fields as necessary
        return outfitRepository.save(existingOutfit);
    }

    public void deleteOutfit(String outfitId) {
        Outfit outfit = getOutfitById(outfitId);
        outfitRepository.delete(outfit);
    }

    public void saveOutfitList(List<Outfit> outfitList) {

        outfitRepository.saveAll(outfitList);
    }

    public List<Outfit> getOutfitsWithinBudget(BigDecimal budget) {
        return outfitRepository.findByTotalCostLessThanEqual(budget);
    }
}
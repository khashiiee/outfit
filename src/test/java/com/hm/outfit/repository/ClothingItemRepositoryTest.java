package com.hm.outfit.repository;

import com.hm.outfit.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClothingItemRepositoryTest {

    @Autowired
    private ClothingItemRepository repository;

    @Test
    public void testSaveAndRetrieveClothingItem() {
        ClothingItem item = new ClothingItem();
        item.setId("1121839001");
        item.setName("Long-sleeved jersey top");
        item.setPrice(new BigDecimal("14.99"));
        item.setInStock(true);

        Set<Color> colors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
        item.setColors(colors);

        Set<Season> seasons = Set.of(Season.SPRING, Season.AUTUMN, Season.WINTER);
        item.setSuitableSeasons(seasons);

        item.setClothingCategory(ClothingCategory.TOP);

        Set<Size> sizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        item.setAvailableSizes(sizes);

        item.setBrand("H&M");
        item.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> productImages = Set.of(
                new ProductImage(1, "ee45850f1c444b7020bdf11246ecd2fcaf0fd29f.jpg", "https://image.hm.com/assets/hm/ee/45/", "PRODUCT"),
                new ProductImage(2, "080734226a9020a093d100fb50778ffdc3b31b5f.jpg", "https://image.hm.com/assets/hm/08/07/", "PRODUCT_WITH_MODEL")
        );
        item.setProductImages(productImages);

        MainCategory mainCategory = new MainCategory(
                "ladies_tops_longsleeve",
                Set.of("ladies", "tops", "longsleeve"),
                "ladies",
                "tops",
                "longsleeve"
        );
        item.setMainCategory(mainCategory);

        ClothingDetails details = new ClothingDetails(
                "Solid color",
                "Regular",
                "Long sleeve",
                "Round neck",
                "Pull-on style",
                "Soft jersey"
        );
        item.setDetails(details);

        repository.save(item);
        Optional<ClothingItem> itemOptional = repository.findById(item.getId());
        assertTrue(itemOptional.isPresent());
        repository.delete(item);

    }

}
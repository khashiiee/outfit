package com.hm.outfit.repository;

import com.hm.outfit.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClothingItemRepositoryTest {

    @Autowired
    private ClothingItemRepository repository;

//    @Test
//    public void testSaveAndRetrieveClothingItem() {
//        ClothingItem item = new ClothingItem();
//        item.setId("1121839001");
//        item.setName("Long-sleeved jersey top");
//        item.setPrice(new BigDecimal("14.99"));
//        item.setInStock(true);
//
//        Set<Color> colors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
//        item.setColors(colors);
//
//        Set<Season> seasons = Set.of(Season.SPRING, Season.AUTUMN, Season.WINTER);
//        item.setSuitableSeasons(seasons);
//
//        item.setClothingCategory(ClothingCategory.TOP);
//
//        Set<Size> sizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
//        item.setAvailableSizes(sizes);
//
//        item.setBrand("H&M");
//        item.setStyle(ClothingStyle.CASUAL);
//
//        Set<ProductImage> productImages = Set.of(
//                new ProductImage(1, "ee45850f1c444b7020bdf11246ecd2fcaf0fd29f.jpg", "https://image.hm.com/assets/hm/ee/45/", "PRODUCT"),
//                new ProductImage(2, "080734226a9020a093d100fb50778ffdc3b31b5f.jpg", "https://image.hm.com/assets/hm/08/07/", "PRODUCT_WITH_MODEL")
//        );
//        item.setProductImages(productImages);
//
//        MainCategory mainCategory = new MainCategory(
//                "ladies_tops_longsleeve",
//                Set.of("ladies", "tops", "longsleeve"),
//                "ladies",
//                "tops",
//                "longsleeve"
//        );
//        item.setMainCategory(mainCategory);
//
//        ClothingDetails details = new ClothingDetails(
//                "Solid color",
//                "Regular",
//                "Long sleeve",
//                "Round neck",
//                "Pull-on style",
//                "Soft jersey"
//        );
//        item.setDetails(details);
//
//        repository.save(item);
//        Optional<ClothingItem> itemOptional = repository.findById(item.getId());
//        assertTrue(itemOptional.isPresent());
////        repository.delete(item);
//
//    }

    @Test
    public void dataInject(){
        // Arrange
        User user = new User();
        user.setId("anne123");
        user.setName("Anne");
        user.setEmail("anne@gmail.com");
        user.setGender(Gender.MALE);
        user.setBirthday(LocalDate.now().minusYears(24));
//        user.setPreferredSizes(Set.of(Size.M,Size.W30L32));
        user.setPreferredSizes(Size.M);
        Set<ClothingStyle> preferredStyles = Set.of(ClothingStyle.CASUAL);
        user.setPreferredStyles(preferredStyles);


        Event event = new Event();
        event.setId("event1");
        event.setName("Birthday Party");
        event.setPreferredStyle(ClothingStyle.CASUAL);
        Set<Color> suitableColors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
        event.setSuitableColors(suitableColors);
//        eventRepository.save(event);


        ClothingItem ladiesTshirt = new ClothingItem();
        ladiesTshirt.setId("1121839001");
        ladiesTshirt.setName("Long-sleeved jersey top");
        ladiesTshirt.setPrice(new BigDecimal("14.99"));
        ladiesTshirt.setInStock(true);

        Set<Color> colors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
        ladiesTshirt.setColors(colors);

        Set<Season> seasons = Set.of(Season.SPRING, Season.AUTUMN, Season.WINTER);
        ladiesTshirt.setSuitableSeasons(seasons);

        ladiesTshirt.setClothingCategory(ClothingCategory.TOP);

        Set<Size> sizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        ladiesTshirt.setAvailableSizes(sizes);

        ladiesTshirt.setBrand("H&M");
        ladiesTshirt.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> productImages = Set.of(
                new ProductImage(1, "ee45850f1c444b7020bdf11246ecd2fcaf0fd29f.jpg", "https://image.hm.com/assets/hm/ee/45/", "PRODUCT"),
                new ProductImage(2, "080734226a9020a093d100fb50778ffdc3b31b5f.jpg", "https://image.hm.com/assets/hm/08/07/", "PRODUCT_WITH_MODEL")
        );
        ladiesTshirt.setProductImages(productImages);

        MainCategory mainCategory = new MainCategory(
                "ladies_tops_longsleeve",
                Set.of("ladies", "tops", "longsleeve"),
                "ladies",
                "tops",
                "longsleeve"
        );
        ladiesTshirt.setMainCategory(mainCategory);

        ClothingDetails details = new ClothingDetails(
                "Solid color",
                "Regular",
                "Long sleeve",
                "Round neck",
                "Pull-on style",
                "Soft jersey"
        );


        ClothingItem dress = new ClothingItem();
        dress.setId("1121839001"); // Assuming this is a unique ID
        dress.setName("Puff-sleeved dress");
        dress.setPrice(new BigDecimal("49.99")); // Price is an estimate, as it's not visible in the images
        dress.setInStock(true);

        Set<Color> colors1 = Set.of(new Color("#000000", "Black", "BLACK"));
        dress.setColors(colors1);

        Set<Season> seasons1 = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN);
        dress.setSuitableSeasons(seasons1);

        dress.setClothingCategory(ClothingCategory.DRESS);

        Set<Size> sizes1 = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        dress.setAvailableSizes(sizes1);

        dress.setBrand("H&M");
        dress.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> productImages1 = Set.of(
                new ProductImage(1, "9f6a4a2f93ef8bc268a1e8c77ed77aa33111aa05.jpg", "https://i.postimg.cc/C1kn2RB4/Capture-2024-07-31-231306.png", "PRODUCT"),
                new ProductImage(2, "960dd87b1757a887f4b67b7df595250add6d70bc.jpg", "https://i.postimg.cc/C1kn2RB4/Capture-2024-07-31-231306.png", "PRODUCT_WITH_MODEL")
        );
        dress.setProductImages(productImages1);

        MainCategory mainCategory1 = new MainCategory(
                "ladies_dresses_shortdresses",
                Set.of("ladies", "dresses", "shortdresses"),
                "ladies",
                "dresses",
                "shortdresses"
        );
        dress.setMainCategory(mainCategory1);

        ClothingDetails details1 = new ClothingDetails(
                "Solid color",
                "Short",
                "Puff sleeve",
                "Round neck",
                "Tie-front closure",
                "Cotton poplin"
        );
        dress.setDetails(details1);

        ClothingItem denimDress = new ClothingItem();
        denimDress.setId("1121839002"); // Assuming this is a unique ID
        denimDress.setName("Denim puff-sleeved dress");
        denimDress.setPrice(new BigDecimal("59.99")); // Price is an estimate, as it's not visible in the images
        denimDress.setInStock(true);

        Set<Color> denimColors = Set.of(new Color("#000080", "Navy Blue", "NAVY"));
        denimDress.setColors(denimColors);

        Set<Season> denimSeasons = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN);
        denimDress.setSuitableSeasons(denimSeasons);

        denimDress.setClothingCategory(ClothingCategory.DRESS);

        Set<Size> denimSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        denimDress.setAvailableSizes(denimSizes);

        denimDress.setBrand("H&M");
        denimDress.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> denimImages = Set.of(
                new ProductImage(1, "510edad78c89668f24227384c4e5dde788f80006.jpg", "https://i.postimg.cc/jjp6c73c/Capture-2024-07-31-225207.png", "PRODUCT"),
                new ProductImage(2, "58259bbdb2f60dd415b704591ec49435ff140003.jpg", "https://i.postimg.cc/QtcQydR3/Capture-2024-07-31-225219.png", "PRODUCT_WITH_MODEL")
        );
        denimDress.setProductImages(denimImages);

        MainCategory denimCategory = new MainCategory(
                "ladies_dresses_shortdresses",
                Set.of("ladies", "dresses", "shortdresses", "denim"),
                "ladies",
                "dresses",
                "shortdresses"
        );
        denimDress.setMainCategory(denimCategory);

        ClothingDetails denimDetails = new ClothingDetails(
                "Solid color",
                "Short",
                "Puff sleeve",
                "Collared",
                "Button-down front",
                "Denim fabric"
        );
        denimDress.setDetails(denimDetails);

        ClothingItem tshirt = new ClothingItem();
        tshirt.setId("1121839003"); // Assuming this is a unique ID
        tshirt.setName("Regular Fit Crew-neck T-shirt");
        tshirt.setPrice(new BigDecimal("12.99")); // Price is an estimate, as it's not visible in the images
        tshirt.setInStock(true);

        Set<Color> tshirtColors = Set.of(new Color("#808080", "Gray", "GRAY"));
        tshirt.setColors(tshirtColors);

        Set<Season> tshirtSeasons = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN);
        tshirt.setSuitableSeasons(tshirtSeasons);

        tshirt.setClothingCategory(ClothingCategory.TOP);

        Set<Size> tshirtSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        tshirt.setAvailableSizes(tshirtSizes);

        tshirt.setBrand("H&M");
        tshirt.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> tshirtImages = Set.of(
                new ProductImage(1, "380609a19cfd897b634bfea723a83df777092531.jpg", "https://i.postimg.cc/tgZtF5k7/Capture-2024-07-31-225155.png", "PRODUCT"),
                new ProductImage(2, "faa71f7684c70f90d887416feba8c448f9120260.jpg", "https://i.postimg.cc/YCyz4V1J/Capture-2024-07-31-225143.png", "PRODUCT_WITH_MODEL")
        );
        tshirt.setProductImages(tshirtImages);

        MainCategory tshirtCategory = new MainCategory(
                "men_tshirtstanks_shortsleeve",
                Set.of("men", "tshirts", "tanks", "shortsleeve"),
                "men",
                "tshirts_tanks",
                "shortsleeve"
        );
        tshirt.setMainCategory(tshirtCategory);

        ClothingDetails tshirtDetails = new ClothingDetails(
                "Solid color",
                "Regular fit",
                "Short sleeve",
                "Crew neck",
                "Pull-on style",
                "Cotton jersey"
        );
        tshirt.setDetails(tshirtDetails);

        ClothingItem jeans = new ClothingItem();
        jeans.setId("1121839004"); // Assuming this is a unique ID
        jeans.setName("Slim Fit Jeans");
        jeans.setPrice(new BigDecimal("34.99")); // Price is an estimate, as it's not visible in the images
        jeans.setInStock(true);

        Set<Color> jeansColors = Set.of(new Color("#4169E1", "Medium Blue", "MEDIUM_BLUE"));
        jeans.setColors(jeansColors);

        Set<Season> jeansSeasons = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER);
        jeans.setSuitableSeasons(jeansSeasons);

        jeans.setClothingCategory(ClothingCategory.BOTTOM);

        Set<Size> jeansSizes = Set.of(Size.M,Size.W28L30, Size.W30L32, Size.W32L32, Size.W34L32, Size.W36L32);
        jeans.setAvailableSizes(jeansSizes);

        jeans.setBrand("H&M");
        jeans.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> jeansImages = Set.of(
                new ProductImage(1, "8bea8bac07ed75596e5597f6d2997f07cfd81fac.jpg", "https://i.postimg.cc/L8sV8RZt/Capture-2024-07-31-225048.png", "PRODUCT"),
                new ProductImage(2, "9fdb8c836462dee3ac65ab6f2276d78a181318ff.jpg", "https://i.postimg.cc/Qxhbvc8n/Capture-2024-07-31-225059.png", "PRODUCT_WITH_MODEL")
        );
        jeans.setProductImages(jeansImages);

        MainCategory jeansCategory = new MainCategory(
                "men_jeans_slim",
                Set.of("men", "jeans", "slim"),
                "men",
                "jeans",
                "slim"
        );
        jeans.setMainCategory(jeansCategory);

        ClothingDetails jeansDetails = new ClothingDetails(
                "Medium wash",
                "Slim fit",
                "Full length",
                "Five-pocket",
                "Button and zip fly",
                "Denim fabric"
        );
        jeans.setDetails(jeansDetails);


        ClothingItem poloShirt = new ClothingItem();
        poloShirt.setId("1121839005"); // Assuming this is a unique ID
        poloShirt.setName("Regular Fit Polo Shirt");
        poloShirt.setPrice(new BigDecimal("19.99")); // Price is an estimate, as it's not visible in the images
        poloShirt.setInStock(true);

        Set<Color> poloColors = Set.of(new Color("#556B2F", "Dark Olive Green", "DARK_OLIVE_GREEN"));
        poloShirt.setColors(poloColors);

        Set<Season> poloSeasons = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN);
        poloShirt.setSuitableSeasons(poloSeasons);

        poloShirt.setClothingCategory(ClothingCategory.TOP);

        Set<Size> poloSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL, Size.XXL);
        poloShirt.setAvailableSizes(poloSizes);

        poloShirt.setBrand("H&M");
        poloShirt.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> poloImages = Set.of(
                new ProductImage(1, "2f9febb6a47d54c555878d2bc5415aaa5df36013.jpg", "https://i.postimg.cc/ZKHcm00Y/Capture-2024-07-31-224907.png", "PRODUCT"),
                new ProductImage(2, "c5c3048b1d0adff184f8e0b9311a7f18247f830e.jpg", "https://i.postimg.cc/ZKHcm00Y/Capture-2024-07-31-224907.png", "PRODUCT_WITH_MODEL")
        );
        poloShirt.setProductImages(poloImages);

        MainCategory poloCategory = new MainCategory(
                "men_tshirtstanks_polo",
                Set.of("men", "tshirts", "tanks", "polo"),
                "men",
                "tshirts_tanks",
                "polo"
        );
        poloShirt.setMainCategory(poloCategory);

        ClothingDetails poloDetails = new ClothingDetails(
                "Solid color",
                "Regular fit",
                "Short sleeve",
                "Polo collar",
                "Two-button placket",
                "Cotton piqué"
        );
        poloShirt.setDetails(poloDetails);


        ClothingItem hoodie = new ClothingItem();
        hoodie.setId("1121839006"); // Assuming this is a unique ID
        hoodie.setName("Relaxed Fit Zip-up Hoodie");
        hoodie.setPrice(new BigDecimal("29.99")); // Price is an estimate, as it's not visible in the images
        hoodie.setInStock(true);

        Set<Color> hoodieColors = Set.of(new Color("#000000", "Black", "BLACK"));
        hoodie.setColors(hoodieColors);

        Set<Season> hoodieSeasons = Set.of(Season.AUTUMN, Season.WINTER, Season.SPRING);
        hoodie.setSuitableSeasons(hoodieSeasons);

        hoodie.setClothingCategory(ClothingCategory.OUTERWEAR);

        Set<Size> hoodieSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL, Size.XXL);
        hoodie.setAvailableSizes(hoodieSizes);

        hoodie.setBrand("H&M");
        hoodie.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> hoodieImages = Set.of(
                new ProductImage(1, "51362531e5440878b0eacd51491f64c2a108feda.jpg", " https://i.postimg.cc/CMj7vcgq/Capture-2024-07-31-224849.png", "PRODUCT"),
                new ProductImage(2, "c910bd309fe0665ec3b3f5836ddb6968b549cde1.jpg", "https://i.postimg.cc/tgZtF5k7/Capture-2024-07-31-225155.png", "PRODUCT_WITH_MODEL")
        );
        hoodie.setProductImages(hoodieImages);

        MainCategory hoodieCategory = new MainCategory(
                "men_hoodiessweatshirts_hoodies",
                Set.of("men", "hoodies", "sweatshirts", "zip-up"),
                "men",
                "hoodies_sweatshirts",
                "hoodies"
        );
        hoodie.setMainCategory(hoodieCategory);

        ClothingDetails hoodieDetails = new ClothingDetails(
                "Solid color",
                "Relaxed fit",
                "Long sleeve",
                "Hooded",
                "Full zip front",
                "Soft sweatshirt fabric"
        );
        hoodie.setDetails(hoodieDetails);

        ClothingItem jacket = new ClothingItem();
        jacket.setId("1121839007"); // Assuming this is a unique ID
        jacket.setName("Hooded Windbreaker Jacket");
        jacket.setPrice(new BigDecimal("49.99")); // Price is an estimate, as it's not visible in the images
        jacket.setInStock(true);

        Set<Color> jacketColors = Set.of(new Color("#F5F5DC", "Beige", "BEIGE"));
        jacket.setColors(jacketColors);

        Set<Season> jacketSeasons = Set.of(Season.SPRING, Season.AUTUMN);
        jacket.setSuitableSeasons(jacketSeasons);

        jacket.setClothingCategory(ClothingCategory.OUTERWEAR);

        Set<Size> jacketSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL, Size.XXL);
        jacket.setAvailableSizes(jacketSizes);

        jacket.setBrand("H&M");
        jacket.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> jacketImages = Set.of(
                new ProductImage(1, "beige_jacket_product.jpg", "https://i.postimg.cc/B6n7WDB0/Capture-2024-07-31-222529.png", "PRODUCT"),
                new ProductImage(2, "beige_jacket_model.jpg", "https://i.postimg.cc/Y9Dnt9dm/Capture-2024-07-31-223417.png", "PRODUCT_WITH_MODEL")
        );
        jacket.setProductImages(jacketImages);

        MainCategory jacketCategory = new MainCategory(
                "men_jackets_lightweight",
                Set.of("men", "jackets", "lightweight", "hooded"),
                "men",
                "jackets",
                "lightweight"
        );
        jacket.setMainCategory(jacketCategory);

        ClothingDetails jacketDetails = new ClothingDetails(
                "Solid color",
                "Regular fit",
                "Long sleeve",
                "Hooded with drawstring",
                "Full zip front",
                "Lightweight water-resistant fabric"
        );
        jacket.setDetails(jacketDetails);


        ClothingItem loafers = new ClothingItem();
        loafers.setId("1121839008"); // Assuming this is a unique ID
        loafers.setName("Suede Tassel Loafers");
        loafers.setPrice(new BigDecimal("59.99")); // Price is an estimate, as it's not visible in the image
        loafers.setInStock(true);

        Set<Color> loaferColors = Set.of(new Color("#000000", "Black", "BLACK"));
        loafers.setColors(loaferColors);

        Set<Season> loaferSeasons = Set.of(Season.SPRING, Season.SUMMER, Season.AUTUMN);
        loafers.setSuitableSeasons(loaferSeasons);

        loafers.setClothingCategory(ClothingCategory.FOOTWEAR);

        Set<Size> loaferSizes = Set.of(Size.S, Size.M, Size.L, Size.XS);
        loafers.setAvailableSizes(loaferSizes);

        loafers.setBrand("& Other Stories"); // Based on the "Stories" text visible on the insole
        loafers.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> loaferImages = Set.of(
                new ProductImage(1, "black_suede_loafers.png", "https://i.postimg.cc/qqpTF0kF/Capture-2024-07-31-233915.png", "PRODUCT")
        );
        loafers.setProductImages(loaferImages);

        MainCategory loaferCategory = new MainCategory(
                "women_shoes_flats",
                Set.of("women", "shoes", "flats", "loafers"),
                "women",
                "shoes",
                "flats"
        );
        loafers.setMainCategory(loaferCategory);

        ClothingDetails loaferDetails = new ClothingDetails(
                "Solid color",
                "Slip-on style",
                "Tassel decoration",
                "Square toe",
                "Flat heel",
                "Suede upper"
        );
        loafers.setDetails(loaferDetails);

        ClothingItem redDress = new ClothingItem();
        redDress.setId("1121839009");
        redDress.setName("Red Cutout Maxi Dress");
        redDress.setPrice(new BigDecimal("89.99"));
        redDress.setInStock(true);

        Set<Color> dressColors = Set.of(new Color("#FF0000", "Red", "RED"));
        redDress.setColors(dressColors);

        Set<Season> dressSeasons = Set.of(Season.SPRING, Season.AUTUMN, Season.WINTER);
        redDress.setSuitableSeasons(dressSeasons);

        redDress.setClothingCategory(ClothingCategory.DRESS);

        Set<Size> dressSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        redDress.setAvailableSizes(dressSizes);

        redDress.setBrand("& Other Stories");
        redDress.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> dressImages = Set.of(
                new ProductImage(1, "red_dress_product.png", "https://i.postimg.cc/02qqYb0C/Capture-2024-08-01-182940.png", "PRODUCT"),
                new ProductImage(2, "red_dress_model.png", "https://i.postimg.cc/02qqYb0C/Capture-2024-08-01-182940.png", "PRODUCT_WITH_MODEL")
        );
        redDress.setProductImages(dressImages);

        MainCategory dressCategory = new MainCategory(
                "women_dresses_maxidresses",
                Set.of("women", "dresses", "maxidresses", "evening"),
                "women",
                "dresses",
                "maxidresses"
        );
        redDress.setMainCategory(dressCategory);

        ClothingDetails dressDetails = new ClothingDetails(
                "Solid color",
                "Bodycon fit",
                "Long sleeve",
                "High neck with cutout",
                "Maxi length",
                "Stretchy jersey fabric"
        );
        redDress.setDetails(dressDetails);

        ClothingItem Bomberjacket = new ClothingItem();
        Bomberjacket.setId("1121839010"); // Assuming this is a unique ID
        Bomberjacket.setName("Oversized Beige Bomber Jacket");
        Bomberjacket.setPrice(new BigDecimal("79.99")); // Price is an estimate, as it's not visible in the image
        Bomberjacket.setInStock(true);

        Set<Color> jacketColors1 = Set.of(new Color("#D2B48C", "Beige", "BEIGE"));
        Bomberjacket.setColors(jacketColors1);

        Set<Season> jacketSeasons1 = Set.of(Season.AUTUMN, Season.SPRING, Season.WINTER);
        Bomberjacket.setSuitableSeasons(jacketSeasons);

        Bomberjacket.setClothingCategory(ClothingCategory.OUTERWEAR);

        Bomberjacket.setAvailableSizes(jacketSizes);

        Bomberjacket.setBrand("H&M"); // Assuming based on the style, but this should be verified
        Bomberjacket.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> jacketImages1 = Set.of(
                new ProductImage(1, "beige_bomber_jacket.png", "https://i.postimg.cc/SK0yvDWw/Capture-2024-08-01-191253.png", "PRODUCT")
        );
        Bomberjacket.setProductImages(jacketImages1);

        MainCategory jacketCategory1 = new MainCategory(
                "women_jackets_bomber",
                Set.of("women", "jackets", "bomber", "casual"),
                "women",
                "jackets",
                "bomber"
        );
        Bomberjacket.setMainCategory(jacketCategory1);

        ClothingDetails jacketDetails1 = new ClothingDetails(
                "Solid color",
                "Oversized fit",
                "Long sleeve",
                "Ribbed collar, cuffs, and hem",
                "Front zip closure",
                "Lightweight padded fabric"
        );
        Bomberjacket.setDetails(jacketDetails1);

        ClothingItem floralDress = new ClothingItem();
        floralDress.setId("1121839011"); // Assuming this is a unique ID
        floralDress.setName("Floral Print Smocked Maxi Dress");
        floralDress.setPrice(new BigDecimal("69.99")); // Price is an estimate, as it's not visible in the image
        floralDress.setInStock(true);

        Set<Color> floralDressColors = Set.of(
                new Color("#FFFFF0", "Ivory", "IVORY"),
                new Color("#FF69B4", "Pink", "PINK"),
                new Color("#FFD700", "Gold", "GOLD"),
                new Color("#FFFFFF", "White", "WHITE")
        );
        floralDress.setColors(floralDressColors);

        Set<Season> floralDressSeasons = Set.of(Season.SPRING, Season.SUMMER);
        floralDress.setSuitableSeasons(floralDressSeasons);

        floralDress.setClothingCategory(ClothingCategory.DRESS);

        Set<Size> floralDressSizes = Set.of(Size.XS, Size.S, Size.M, Size.L, Size.XL);
        floralDress.setAvailableSizes(floralDressSizes);

        floralDress.setBrand("H&M"); // Assuming based on the style, but this should be verified
        floralDress.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> floralDressImages = Set.of(
                new ProductImage(1, "floral_maxi_dress.png", "https://i.postimg.cc/1zgvfr25/Capture-2024-08-01-192349.png", "PRODUCT")
        );
        floralDress.setProductImages(floralDressImages);

        MainCategory floralDressCategory = new MainCategory(
                "women_dresses_maxidresses",
                Set.of("women", "dresses", "maxidresses", "floral", "summer"),
                "women",
                "dresses",
                "maxidresses"
        );
        floralDress.setMainCategory(floralDressCategory);

        ClothingDetails floralDressDetails = new ClothingDetails(
                "Floral print",
                "Maxi length",
                "Short puff sleeves",
                "Square neckline",
                "Smocked bodice",
                "Lightweight fabric"
        );
        floralDress.setDetails(floralDressDetails);

        ClothingItem handbag = new ClothingItem();
        handbag.setId("1121839012"); // Assuming this is a unique ID
        handbag.setName("White Ruched Shoulder Bag with Ruffled Strap");
        handbag.setPrice(new BigDecimal("39.99")); // Price is an estimate, as it's not visible in the image
        handbag.setInStock(true);

        Set<Color> handbagColors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
        handbag.setColors(handbagColors);

        Set<Season> handbagSeasons = Set.of(Season.SPRING, Season.SUMMER);
        handbag.setSuitableSeasons(handbagSeasons);

        handbag.setClothingCategory(ClothingCategory.ACCESSORIES);

        Set<Size> handbagSizes = Set.of(Size.ONESIZE);
        handbag.setAvailableSizes(handbagSizes);

        handbag.setBrand("H&M"); // Assuming based on the style, but this should be verified
        handbag.setStyle(ClothingStyle.CASUAL);

        Set<ProductImage> handbagImages = Set.of(
                new ProductImage(1, "white_ruched_handbag.png", "https://i.postimg.cc/sfnGNC1q/Capture-2024-08-01-193032.png", "PRODUCT")
        );
        handbag.setProductImages(handbagImages);

        MainCategory handbagCategory = new MainCategory(
                "women_accessories_bags",
                Set.of("women", "accessories", "bags", "shoulder_bags"),
                "women",
                "accessories",
                "bags"
        );
        handbag.setMainCategory(handbagCategory);

        ClothingDetails handbagDetails = new ClothingDetails(
                "Solid color",
                "Ruched design",
                "Ruffled shoulder strap",
                "Crescent shape",
                "Zip closure",
                "Satin-like fabric"
        );
        handbag.setDetails(handbagDetails);

        List<ClothingItem> items = Arrays.asList(ladiesTshirt, denimDress, dress, tshirt, jeans, poloShirt,hoodie,jacket,loafers,redDress,Bomberjacket, floralDress,handbag);

        repository.saveAll(items);
    }

}
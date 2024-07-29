package com.hm.outfit.model;

import java.util.Set;

public record MainCategory(
        String code,
        Set<String> categories,
        String gender,
        String mainCategory,
        String specificCategory
) {}


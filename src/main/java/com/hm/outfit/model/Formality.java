package com.hm.outfit.model;

public enum Formality {
    VERY_CASUAL(1),
    CASUAL(2),
    SMART_CASUAL(3),
    BUSINESS_CASUAL(4),
    BUSINESS_FORMAL(5),
    FORMAL(6);

    private final int level;

    Formality(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

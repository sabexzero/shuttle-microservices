package org.example.pilotrankservice.utils;

public enum ExperienceConstants {
    DEFAULT_EXPERIENCE_CHANGE_AMOUNT(4),
    EXPERIENCE_LEVEL_TO_INCREASE_RANK(200);

    final int xp;
    ExperienceConstants(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }
}

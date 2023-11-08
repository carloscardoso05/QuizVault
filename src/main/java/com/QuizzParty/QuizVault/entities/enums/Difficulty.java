package com.QuizzParty.QuizVault.entities.enums;

public enum Difficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3);
    private final int code;

    Difficulty(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public Difficulty valueOf(int code) throws IllegalArgumentException {
        for (Difficulty difficulty : values()) {
            if (difficulty.getCode() == code) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("Invalid Difficulty code");
    }
}

package ru.redguy.redguyapi.math;

public enum NumberLevels {
    factorial("fact1"),
    superFactorial("fact2"),
    hyperFactorial("fact3"),
    megaFactorial("fact4"),
    gigaFactorial("fact5"),
    sixFactorial("fact6"),
    sevenFactorial("fact7"),
    eighthFactorial("fact8"),
    nineFactorial("fact9"),
    tenFactorial("fact10");

    private final String level;

    NumberLevels(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    };
}

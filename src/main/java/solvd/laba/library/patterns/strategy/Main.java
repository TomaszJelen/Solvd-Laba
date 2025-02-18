package solvd.laba.library.patterns.strategy;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal value = BigDecimal.valueOf(100);
        Discounter christmasDiscounter = Discounter.christmasDiscounter();
        BigDecimal christmasValue = count(christmasDiscounter, value);
    }

    private static BigDecimal count(Discounter discounter, BigDecimal value) {
        return discounter.applyDiscount(value);
    }
}

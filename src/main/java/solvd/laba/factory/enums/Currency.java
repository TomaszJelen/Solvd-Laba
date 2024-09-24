package solvd.laba.factory.enums;

//TODO enum done?
public enum Currency {
    EURO("EUR","Euro"),
    ZLOTY("PLN", "Zloty"),
    POUND("GBP", "Sterling"),
    FRANC("Fr", "Swiss franc");

    private final String abbreviation;
    private final String name;

    Currency(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}

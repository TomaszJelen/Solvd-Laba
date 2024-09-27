package solvd.laba.factory.enums;

public enum Country {
    GER("DE", "Germany"),
    FR("FR", "France"),
    PL("PL", "Poland"),
    Uk("UK","United Kingdom"),
    SWISS("CH", "Switzerland");

    private final String abbreviation;
    private final String name;

    Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

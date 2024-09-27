package solvd.laba.factory.enums;

public enum Sex {
    MALE("M", "male"),
    FEMALE("F", "female"),
    OTHER("O", "other") {
        @Override
        public String toString() {
            return "other/undeclared";
        }
    };

    private final String abbreviation;
    private final String name;

    Sex(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

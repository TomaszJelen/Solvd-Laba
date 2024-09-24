package solvd.laba.factory.enums;

//TODO enum done?
public enum InspectionFrequency {
    WEEKLY("Monday"),
    MONTHLY("First monday of month"),
    YEARLY("First monday of year");

    private final String day;

    InspectionFrequency(String day) {
        this.day = day;
    }
}

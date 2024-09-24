package solvd.laba.factory.enums;

//TODO enum done?
public enum PowerConsumption {
    HIGH(10000),
    MEDIUM(1000),
    LOW(100);
    private final int averagePower;

    PowerConsumption(int averagePower) {
        this.averagePower = averagePower;
    }

    public int getAveragePower() {
        return averagePower;
    }
}

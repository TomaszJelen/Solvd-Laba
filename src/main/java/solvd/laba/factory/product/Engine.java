package solvd.laba.factory.product;

import solvd.laba.factory.exceptions.NegativeArgumentException;

public class Engine extends Product{
    private int power;

    public Engine(String type, int power, int value) {
        this.type = type;
        this.power = power;
        this.value = value;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new NegativeArgumentException("Power cannot be lower than 0");
        }
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine model " + type + " power: " + power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine engine)) return false;
        if (!super.equals(o)) return false;

        return power == engine.power;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        return result;
    }
}

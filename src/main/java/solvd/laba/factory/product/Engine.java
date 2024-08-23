package solvd.laba.factory.product;

public class Engine extends Product{
    private int power;

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
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

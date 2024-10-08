package solvd.laba.factory.product;

import solvd.laba.factory.exceptions.NullArgumentException;

public class CarModel extends Product {
    public static final int STANDARD_NUMBER_OF_WHEELS = 4;
    private Engine engine;

    public CarModel(String type, Engine engine, int value) {
        this.type = type;
        this.engine = engine;
        this.value = value;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new NullArgumentException("Engine cannot be null");
        }
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car model " + type + " with engine " + engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarModel carModel)) return false;
        if (!super.equals(o)) return false;

        return engine.equals(carModel.engine);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }
}

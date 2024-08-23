package solvd.laba.factory.product;

public class CarModel extends Product {
    static int numberOfWheels;
    private Engine engine;

    public CarModel(String type, Engine engine) {
        this.type = type;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public static void declareNumberOfWheels(int number) {
        numberOfWheels = number;
        System.out.println("Our company will now create cars with " + numberOfWheels + " wheels!");
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

package laba.solvd.product;

public class CarModel {
    String type;
    static int numberOfWheels;
    Engine engine;

    public CarModel(String type, Engine engine) {
        this.type = type;
        this.engine = engine;
    }

    public static void declareNumberOfWheels(int number) {
        numberOfWheels = number;
        System.out.println("Our company will now create cars with " + numberOfWheels + " wheels!");
    }
}

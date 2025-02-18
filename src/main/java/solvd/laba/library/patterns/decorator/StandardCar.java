package solvd.laba.library.patterns.decorator;

public class StandardCar extends Car {
    @Override
    public float price() {
        return 20000;
    }
    @Override
    public String description() {
        return "Standard car";
    }
}
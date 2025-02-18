package solvd.laba.library.patterns.decorator;

public class Armrest extends CarAcessoriesDecorator {

    public Armrest(Car car) {
        this.car = car;
    }

    @Override
    public float price() {
        return car.price() + 500F;
    }

    @Override
    public String description() {
        return car.description() + " with armrest";
    }
}
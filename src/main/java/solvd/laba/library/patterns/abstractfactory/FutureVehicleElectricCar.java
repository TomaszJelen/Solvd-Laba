package solvd.laba.library.patterns.abstractfactory;

public class FutureVehicleElectricCar implements ElectricVehicle {
    @Override
    public void build() {
        System.out.println("Future Vehicle Electric Car");
    }
}

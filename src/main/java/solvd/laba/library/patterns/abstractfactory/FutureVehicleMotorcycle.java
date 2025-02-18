package solvd.laba.library.patterns.abstractfactory;

import solvd.laba.library.patterns.factory.MotorVehicle;

public class FutureVehicleMotorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Future Vehicle Motorcycle");
    }
}

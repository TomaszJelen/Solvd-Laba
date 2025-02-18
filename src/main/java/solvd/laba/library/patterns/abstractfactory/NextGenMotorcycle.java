package solvd.laba.library.patterns.abstractfactory;

import solvd.laba.library.patterns.factory.MotorVehicle;

public class NextGenMotorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("NextGen Motorcycle");
    }
}

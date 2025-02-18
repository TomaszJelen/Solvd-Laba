package solvd.laba.library.patterns.abstractfactory;

import solvd.laba.library.patterns.factory.MotorVehicle;

public class NextGenCorporation extends Corporation {
    @Override
    public MotorVehicle createMotorVehicle() {
        return new NextGenMotorcycle();
    }
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new NextGenElectricCar();
    }
}
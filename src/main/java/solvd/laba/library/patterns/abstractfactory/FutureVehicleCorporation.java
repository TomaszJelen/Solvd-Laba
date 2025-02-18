package solvd.laba.library.patterns.abstractfactory;

import solvd.laba.library.patterns.factory.MotorVehicle;

public class FutureVehicleCorporation extends Corporation {
    @Override
    public MotorVehicle createMotorVehicle() {
        return new FutureVehicleMotorcycle();
    }
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new FutureVehicleElectricCar();
    }
}
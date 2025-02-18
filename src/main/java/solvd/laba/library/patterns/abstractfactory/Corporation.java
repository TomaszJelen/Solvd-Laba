package solvd.laba.library.patterns.abstractfactory;

import solvd.laba.library.patterns.factory.MotorVehicle;

public abstract class Corporation {
    public abstract MotorVehicle createMotorVehicle();
    public abstract ElectricVehicle createElectricVehicle();
}

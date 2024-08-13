package laba.solvd.production;

import laba.solvd.people.Manager;
import laba.solvd.product.CarModel;

public class ProductionLine {
    Manager manager;
    Workstation[] workstations;
    CarModel carModel;
    int carProduced = 0;
    static int totalCarProduced = 0;

    public ProductionLine(Workstation[] workstations) {
        this.workstations = workstations;
    }

    public ProductionLine(Manager manager, Workstation[] workstations, CarModel carModel) {
        this.manager = manager;
        this.workstations = workstations;
        this.carModel = carModel;
    }

    int calculateTotalSalary() {
        int totalSalary = 0;
        for (Workstation workstation : workstations) {
            totalSalary += workstation.calculateSalary();
        }
        totalSalary += manager.getSalary();
        return totalSalary;
    }
    void produceCar() {
        carProduced++;
        totalCarProduced++;
    }
}

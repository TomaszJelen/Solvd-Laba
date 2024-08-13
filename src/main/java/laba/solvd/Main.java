package laba.solvd;

import laba.solvd.organisation.Company;
import laba.solvd.organisation.Location;
import laba.solvd.organisation.Supplier;
import laba.solvd.people.Manager;
import laba.solvd.people.Worker;
import laba.solvd.product.CarModel;
import laba.solvd.product.Engine;
import laba.solvd.production.Factory;
import laba.solvd.production.ProductionLine;
import laba.solvd.production.Workstation;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Let's create Car company with 1 factory");
        CarModel.declareNumberOfWheels(4);

        Engine engine = new Engine("Type I", 100);
        CarModel carModel = new CarModel("T1", engine);
        Worker worker = new Worker("John", "Doe", 1, 8000, "Example of worker");
        Workstation workstation = new Workstation(1);
        workstation.worker = worker;
        Manager manager = new Manager("Jane", "Smith", 10, LocalDate.now(), 15000);
        ProductionLine productionLine = new ProductionLine(manager, new Workstation[]{workstation}, carModel);

        Location location = new Location(100000, "Example 1");
        Supplier supplier = new Supplier("Supplies inc.");
        Manager chiefManager = new Manager("Adam", "Jones", 100, LocalDate.now(), 28000);
        Factory factory = new Factory(location, chiefManager, new ProductionLine[]{productionLine},
                new Supplier[]{supplier}, LocalDate.now());
        Company company = new Company("Car company");
        company.factories = new Factory[]{factory};

    }
}
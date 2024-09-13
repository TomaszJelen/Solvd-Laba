package solvd.laba.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.employees.ChiefManager;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.employees.Worker;
import solvd.laba.factory.organisation.Company;
import solvd.laba.factory.organisation.Location;
import solvd.laba.factory.organisation.Supplier;
import solvd.laba.factory.product.CarModel;
import solvd.laba.factory.product.Engine;
import solvd.laba.factory.production.Factory;
import solvd.laba.factory.production.ProductionLine;
import solvd.laba.factory.production.Workstation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.trace("Program start");
        System.out.println("Let's create Car company with 1 factory");
        LOGGER.info("Let's create Car company with 1 factory");

//        CarModel.declareNumberOfWheels(4);

        System.out.print("Enter planned factory opening date (yyyy-mm-dd): ");
        LocalDate openingDate;
        try (Scanner scanner = new Scanner(System.in)) {
            String dateString = scanner.next();
            openingDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        }

        try {
            Engine engine = new Engine("Type I", 100, 20000);
            CarModel carModel = new CarModel("T1", engine, 70000);
            Worker worker = new Worker("John", "Doe", 1, openingDate, "Example of worker");
            Workstation workstation = new Workstation(1);
            workstation.setWorker(worker);
            Manager manager = new Manager("Jane", "Smith", 10, openingDate);
            ProductionLine productionLine = new ProductionLine(manager, new Workstation[]{workstation}, carModel);

            Location location = new Location(100000, "Example 1");
            Supplier supplier = new Supplier("Supplies inc.");
            ChiefManager chiefManager = new ChiefManager("Adam", "Jones", 100, openingDate);
            Factory factory = new Factory(location, chiefManager, new ProductionLine[]{productionLine},
                    new Supplier[]{supplier}, openingDate);
            Company company = new Company("Car company");
            company.setFactories(new Factory[]{factory});
        } catch (Exception e) {

        }

    }
}
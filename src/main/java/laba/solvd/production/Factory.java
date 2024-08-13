package laba.solvd.production;

import laba.solvd.organisation.Location;
import laba.solvd.organisation.Supplier;
import laba.solvd.people.Manager;

import java.time.LocalDate;

public class Factory {
    Location location;
    Manager chiefManager;
    ProductionLine[] productionLines;
    Supplier[] suppliers;
    LocalDate openingDate;


    public Factory(Location location, ProductionLine[] productionLines) {
        this.location = location;
        this.productionLines = productionLines;
    }

    public Factory(Location location, ProductionLine[] productionLines, LocalDate openingDate) {
        this.location = location;
        this.productionLines = productionLines;
        this.openingDate = openingDate;
    }

    public Factory(Location location, Manager chiefManager, ProductionLine[] productionLines, Supplier[] suppliers, LocalDate openingDate) {
        this.location = location;
        this.chiefManager = chiefManager;
        this.productionLines = productionLines;
        this.suppliers = suppliers;
        this.openingDate = openingDate;
    }

    int calculateTotalSalary() {
        int totalSalary = 0;
        for (ProductionLine productionLine : productionLines) {
            totalSalary += productionLine.calculateTotalSalary();
        }
        totalSalary += chiefManager.getSalary();
        return totalSalary;
    }
}

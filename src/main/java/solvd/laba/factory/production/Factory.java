package solvd.laba.factory.production;

import solvd.laba.factory.organisation.Location;
import solvd.laba.factory.organisation.Supplier;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.Money;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Factory {
    private Location location;
    private Manager chiefManager;
    private ProductionLine[] productionLines;
    private Supplier[] suppliers;
    private LocalDate openingDate;


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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Manager getChiefManager() {
        return chiefManager;
    }

    public void setChiefManager(Manager chiefManager) {
        this.chiefManager = chiefManager;
    }

    public ProductionLine[] getProductionLines() {
        return productionLines;
    }

    public void setProductionLines(ProductionLine[] productionLines) {
        this.productionLines = productionLines;
    }

    public Supplier[] getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Supplier[] suppliers) {
        this.suppliers = suppliers;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    Money calculateTotalSalary() {
        Money totalSalary = new Money(0, "EUR");
        for (ProductionLine productionLine : productionLines) {
            totalSalary.add(productionLine.calculateTotalSalary());
        }
        totalSalary.add(chiefManager.getSalary());
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Factory at " + location.getAdress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factory factory)) return false;

        if (!location.equals(factory.location)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(productionLines, factory.productionLines)) return false;
        return Objects.equals(openingDate, factory.openingDate);
    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + Arrays.hashCode(productionLines);
        result = 31 * result + (openingDate != null ? openingDate.hashCode() : 0);
        return result;
    }
}

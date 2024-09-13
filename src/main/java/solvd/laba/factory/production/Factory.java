package solvd.laba.factory.production;

import solvd.laba.factory.employees.ChiefManager;
import solvd.laba.factory.employees.Employee;
import solvd.laba.factory.exceptions.InvalidDateException;
import solvd.laba.factory.exceptions.NullArgumentException;
import solvd.laba.factory.organisation.Location;
import solvd.laba.factory.organisation.Supplier;
import solvd.laba.factory.employees.Manager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Factory implements SalaryCalculation, EmployeeListing, IncomeNettoCalculation {
    private Location location;
    private ChiefManager chiefManager;
    private ProductionLine[] productionLines;
    private Supplier[] suppliers;
    private LocalDate openingDate;
    private Storage storage;


    public Factory(Location location, ProductionLine[] productionLines) {
        this.location = location;
        this.productionLines = productionLines;
    }

    public Factory(Location location, ProductionLine[] productionLines, LocalDate openingDate) throws InvalidDateException {
        this.location = location;
        this.productionLines = productionLines;
        if (openingDate.isAfter(LocalDate.now().plusYears(10))) {
            throw new InvalidDateException("Plans cannot be made more than 10 years in future");
        }
        this.openingDate = openingDate;
    }

    public Factory(Location location, ChiefManager chiefManager, ProductionLine[] productionLines, Supplier[] suppliers, LocalDate openingDate) {
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
        if (location == null) {
            throw new NullArgumentException("Location cannot be null");
        }
        this.location = location;
    }

    public Manager getChiefManager() {
        return chiefManager;
    }

    public void setChiefManager(ChiefManager chiefManager) {
        if (chiefManager == null) {
            throw new NullArgumentException("Chief manager cannot be null");
        }
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

    public Storage getStorage() { return storage; }

    public void setStorage(Storage storage) {
        if (storage == null) {
            throw new NullArgumentException("Storage cannot be null");
        }
        this.storage = storage;
    }

    @Override
    public int calculateTotalSalary() {
        int totalSalary = 0;
        for (ProductionLine productionLine : productionLines) {
            totalSalary += productionLine.calculateTotalSalary();
        }
        totalSalary += chiefManager.getSalary();
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Factory at " + location.getAddress();
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

    @Override
    public Set<Employee> workingEmployees() {
        Set<Employee> employees = new HashSet<>();
        for (ProductionLine productionLine : productionLines) {
            employees.addAll(productionLine.workingEmployees());
        }
        employees.add(chiefManager);
        return employees;
    }

    @Override
    public int calculateTotalIncomeNetto() {
         int income = 0;
        for (ProductionLine productionLine : productionLines) {
            income += productionLine.calculateTotalIncomeNetto();
        }
        return income;
    }
}

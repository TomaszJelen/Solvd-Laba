package solvd.laba.factory.production;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.Main;
import solvd.laba.factory.employees.ChiefManager;
import solvd.laba.factory.employees.Employee;
import solvd.laba.factory.exceptions.InvalidDateException;
import solvd.laba.factory.exceptions.NullArgumentException;
import solvd.laba.factory.organisation.Location;
import solvd.laba.factory.organisation.Supplier;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.util.CustomLinkedList;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;

public class Factory implements SalaryCalculation, EmployeeListing, IncomeNettoCalculation {
    static final Logger LOGGER = LogManager.getLogger(Factory.class);
    private Location location;
    private ChiefManager chiefManager;
//    private ProductionLine[] productionLines;
    private CustomLinkedList<ProductionLine> productionLines;
    private Set<Supplier> suppliers;
    private LocalDate openingDate;
    private Storage storage;


    public Factory(Location location, CustomLinkedList<ProductionLine> productionLines) {
        this.location = location;
        this.productionLines = productionLines;
    }

    public Factory(Location location, CustomLinkedList<ProductionLine> productionLines, LocalDate openingDate) throws InvalidDateException {
        this.location = location;
        this.productionLines = productionLines;
        if (openingDate.isAfter(LocalDate.now().plusYears(10))) {
            throw new InvalidDateException("Plans cannot be made more than 10 years in future");
        }
        this.openingDate = openingDate;
    }

    public Factory(Location location, ChiefManager chiefManager, CustomLinkedList<ProductionLine> productionLines, Set<Supplier> suppliers, LocalDate openingDate) {
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

    public CustomLinkedList<ProductionLine> getProductionLines() {
        return productionLines;
    }

    public void setProductionLines(CustomLinkedList<ProductionLine> productionLines) {
        this.productionLines = productionLines;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
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
//        int totalSalary = 0;
        //TODO stream done
        int totalSalary = productionLines.stream()
                .map(ProductionLine::calculateTotalSalary)
                .reduce(0, Integer::sum);
//        for (ProductionLine productionLine : productionLines) {
//            totalSalary += productionLine.calculateTotalSalary();
//        }
        totalSalary += chiefManager.getSalary().orElseGet(() -> {
            LOGGER.info("Ignored empty salary field");
            return 0;
        });
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
        if (!productionLines.equals(factory.productionLines)) return false;
        return Objects.equals(openingDate, factory.openingDate);
    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + productionLines.hashCode();
        result = 31 * result + (openingDate != null ? openingDate.hashCode() : 0);
        return result;
    }

    @Override
    public Set<Employee> workingEmployees() {
        Set<Employee> employees = new HashSet<>();
        //TODO stream done
        productionLines.stream()
                .map(ProductionLine::workingEmployees)
                .forEach(employees::addAll);
//        for (ProductionLine productionLine : productionLines) {
//            employees.addAll(productionLine.workingEmployees());
//        }
        employees.add(chiefManager);
        return employees;
    }

    @Override
    public int calculateTotalIncomeNetto() {
//         int income = 0;
         //TODO stream done
//        for (ProductionLine productionLine : productionLines) {
//            income += productionLine.calculateTotalIncomeNetto();
//        }
        return productionLines.stream()
                .map(ProductionLine::calculateTotalIncomeNetto)
                .reduce(0, Integer::sum);
    }
}

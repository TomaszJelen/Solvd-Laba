package solvd.laba.factory.production;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.employees.Employee;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.enums.InspectionFrequency;
import solvd.laba.factory.enums.PowerConsumption;
import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.exceptions.NullArgumentException;
import solvd.laba.factory.product.CarModel;
import solvd.laba.factory.util.CollectionCalculation;
import solvd.laba.factory.util.CustomLinkedList;

import java.util.*;

public class ProductionLine implements SalaryCalculation, EmployeeListing, IncomeNettoCalculation {
    static final Logger LOGGER = LogManager.getLogger(ProductionLine.class);
    private Manager manager;
//    private Workstation[] workstations;
    private CustomLinkedList<Workstation> workstations;
    private CarModel carModel;
    private int productionLineCarProduced;
    private static int globalCarProduced = 0;
    private InspectionFrequency inspectionFrequency;

    public ProductionLine(CustomLinkedList<Workstation> workstations) {
        this.workstations = workstations;
    }

    public ProductionLine(Manager manager, CustomLinkedList<Workstation> workstations, CarModel carModel) {
        this.manager = manager;
        this.workstations = workstations;
        this.carModel = carModel;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if (manager == null) {
            throw new NullArgumentException("Manager cannot be null");
        }
        this.manager = manager;
    }

    public CustomLinkedList<Workstation> getWorkstations() {
        return workstations;
    }

    public void setWorkstations(CustomLinkedList<Workstation> workstations) {
        this.workstations = workstations;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        if (carModel == null) {
            throw new NullArgumentException("Car model cannot be null");
        }
        this.carModel = carModel;
    }

    public int getProductionLineCarProduced() {
        return productionLineCarProduced;
    }

    public void setProductionLineCarProduced(int productionLineCarProduced) {
        if (productionLineCarProduced < 0) {
            throw new NegativeArgumentException("Number of produced cars cannot be lower than 0");
        }
        this.productionLineCarProduced = productionLineCarProduced;
    }

    public static int getGlobalCarProduced() {
        return globalCarProduced;
    }

    public static void setGlobalCarProduced(int globalCarProduced) {
        ProductionLine.globalCarProduced = globalCarProduced;
    }

    @Override
    public int calculateTotalSalary() {
//        int totalSalary = 0;
        int totalSalary = workstations.stream()
                .map(Workstation::calculateSalary)
                .reduce(0, Integer::sum);
//        for (Workstation workstation : workstations) {
//            totalSalary += workstation.calculateSalary();
//        }
        totalSalary += manager.getSalary().orElseGet(() -> {
            LOGGER.info("Ignored empty salary field");
            return 0;
        });
        return totalSalary;
    }
    void produceCar() {
        productionLineCarProduced++;
        globalCarProduced++;
        System.out.println("Car has been made");
    }

    @Override
    public String toString() {
        return "Production line managed by: " + manager + "producing: " + carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionLine that)) return false;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!workstations.equals(that.workstations)) return false;
        return Objects.equals(carModel, that.carModel);
    }

    @Override
    public int hashCode() {
        int result = workstations.hashCode();
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        return result;
    }

    @Override
    public Set<Employee> workingEmployees() {
        Set<Employee> employees = new HashSet<>();
        for (Workstation workstation : workstations) {
            employees.addAll(workstation.workingEmployees());
        }
        employees.add(manager);
        return employees;
    }

    @Override
    public int calculateTotalIncomeNetto() {
        return 30 * carModel.getValue();
    }

    private int getCollectionCalculationValue(Collection collection, CollectionCalculation calculation) {
        return calculation.calculate(collection);
    }

    public void printAveragePowerConsumption() {
        System.out.println(getCollectionCalculationValue(workstations, (collection) -> {
            return (int) collection.stream()
                    .map((workstation) -> ((Workstation) workstation).getPowerConsumption())
                    .mapToInt((powerConsumption) -> ((PowerConsumption) powerConsumption).getAveragePower())
                    .average()
                    .getAsDouble();
        }));
    }

    public void printWeeklyInspectionCounter() {
        System.out.println(getCollectionCalculationValue(workstations, (collection) -> {
            return Math.toIntExact(collection.stream()
                    .filter((workstation) -> ((Workstation) workstation).getInspectionFrequency().equals(InspectionFrequency.WEEKLY))
                    .count());
        }));
    }
}

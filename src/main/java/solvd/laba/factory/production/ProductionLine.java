package solvd.laba.factory.production;

import solvd.laba.factory.employees.Employee;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.product.CarModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductionLine implements SalaryCalculation, EmployeeListing, IncomeNettoCalculation {
    private Manager manager;
    private Workstation[] workstations;
    private CarModel carModel;
    private int productionLineCarProduced;
    private static int globalCarProduced = 0;

    public ProductionLine(Workstation[] workstations) {
        this.workstations = workstations;
    }

    public ProductionLine(Manager manager, Workstation[] workstations, CarModel carModel) {
        this.manager = manager;
        this.workstations = workstations;
        this.carModel = carModel;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Workstation[] getWorkstations() {
        return workstations;
    }

    public void setWorkstations(Workstation[] workstations) {
        this.workstations = workstations;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public int getProductionLineCarProduced() {
        return productionLineCarProduced;
    }

    public void setProductionLineCarProduced(int productionLineCarProduced) {
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
        int totalSalary = 0;
        for (Workstation workstation : workstations) {
            totalSalary += workstation.calculateSalary();
        }
        totalSalary += manager.getSalary();
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
        if (!Arrays.equals(workstations, that.workstations)) return false;
        return Objects.equals(carModel, that.carModel);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(workstations);
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
}

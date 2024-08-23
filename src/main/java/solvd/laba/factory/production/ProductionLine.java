package solvd.laba.factory.production;

import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.product.Product;
import solvd.laba.factory.Money;

import java.util.Arrays;
import java.util.Objects;

public class ProductionLine {
    private Manager manager;
    private Workstation[] workstations;
    private Product product;
    private int carProduced = 0;
    private static int totalCarProduced = 0;

    public ProductionLine(Workstation[] workstations) {
        this.workstations = workstations;
    }

    public ProductionLine(Manager manager, Workstation[] workstations, Product product) {
        this.manager = manager;
        this.workstations = workstations;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCarProduced() {
        return carProduced;
    }

    public void setCarProduced(int carProduced) {
        this.carProduced = carProduced;
    }

    public static int getTotalCarProduced() {
        return totalCarProduced;
    }

    public static void setTotalCarProduced(int totalCarProduced) {
        ProductionLine.totalCarProduced = totalCarProduced;
    }

    Money calculateTotalSalary() {
        Money totalSalary = new Money(0, "EUR");
        for (Workstation workstation : workstations) {
            totalSalary.add(workstation.calculateSalary());
        }
        totalSalary.add(manager.getSalary());
        return totalSalary;
    }
    void produceCar() {
        carProduced++;
        totalCarProduced++;
        System.out.println("Car has been made");
    }

    @Override
    public String toString() {
        return "Production line managed by: " + manager + "producing: " + product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionLine that)) return false;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(workstations, that.workstations)) return false;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(workstations);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}

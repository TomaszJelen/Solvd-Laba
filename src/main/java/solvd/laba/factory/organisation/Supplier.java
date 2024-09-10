package solvd.laba.factory.organisation;

import solvd.laba.factory.employees.LengthOfServiceCalculation;
import solvd.laba.factory.production.ExpenseCalculation;

import java.time.LocalDate;
import java.time.Period;

public class Supplier implements ExpenseCalculation, LengthOfServiceCalculation {
    private String name;
    private String[] parts;
    private int cost;
    private LocalDate cooperateSince;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getCooperateSince() {
        return cooperateSince;
    }

    public void setCooperateSince(LocalDate cooperateSince) {
        this.cooperateSince = cooperateSince;
    }

    @Override
    public String toString() {
        return "Supplier " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier supplier)) return false;

        return name.equals(supplier.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int calculateTotalExpense() {
        return getCost();
    }

    @Override
    public int calculateMonthsLengthOfService() {
        return Period.between(cooperateSince, LocalDate.now()).getMonths();
    }

    @Override
    public int calculateYearsLengthOfService() {
        return Period.between(cooperateSince, LocalDate.now()).getYears();
    }
}

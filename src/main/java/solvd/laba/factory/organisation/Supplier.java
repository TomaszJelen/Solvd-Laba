package solvd.laba.factory.organisation;

import solvd.laba.factory.employees.LengthOfServiceCalculation;
import solvd.laba.factory.exceptions.InvalidStringException;
import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.production.ExpenseCalculation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class Supplier implements ExpenseCalculation, LengthOfServiceCalculation {
    private String name;
    private Map<String, Integer> parts;
    private LocalDate cooperateSince;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new InvalidStringException("Supplier name should not be empty");
        }
        this.name = name;
    }

    public Map<String, Integer> getParts() {
        return parts;
    }

    public void setParts(Map<String, Integer> parts) {
        this.parts = parts;
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
        int payment = 0;
        for (Map.Entry<String, Integer> part : parts.entrySet()) {
            payment += part.getValue();
        }
        return payment;
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

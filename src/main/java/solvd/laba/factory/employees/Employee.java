package solvd.laba.factory.employees;

import solvd.laba.factory.Person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Employee extends Person implements LengthOfServiceCalculation {
    protected int id;
    //double isn't accurate enough for money but must do for now
    protected int salary;
    protected LocalDate workingSince;

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getWorkingSince() {
        return workingSince;
    }

    public void setWorkingSince(LocalDate workingSince) {
        this.workingSince = workingSince;
    }

    public abstract void printPosition();
    public abstract int calculateStandardBonus(int salary);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        if (!super.equals(o)) return false;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public int calculateMonthsLengthOfService() {
        return Period.between(workingSince, LocalDate.now()).getMonths();
    }

    @Override
    public int calculateYearsLengthOfService() {
        return Period.between(workingSince, LocalDate.now()).getYears();
    }
}

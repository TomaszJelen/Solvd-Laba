package solvd.laba.factory.employees;

import solvd.laba.factory.Person;
import solvd.laba.factory.exceptions.NegativeArgumentException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public abstract class Employee extends Person implements LengthOfServiceCalculation {
    protected int id;
    protected int salary;
    protected LocalDate workingSince;

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        if (id < 0) {
            throw new NegativeArgumentException("Id cannot be lower than 0");
        }
        this.id = id;
    }

    // TODO optional done
    public Optional<Integer> getSalary() {
        return Optional.of(salary);
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new NegativeArgumentException("Salary cannot be lower than 0");
        }
        this.salary = salary;
    }

    // TODO optional done?
    public Optional<LocalDate> getWorkingSince() {
        return Optional.ofNullable(workingSince);
    }

    public void setWorkingSince(LocalDate workingSince) {
        this.workingSince = workingSince;
    }

    public abstract void printPosition();
    public abstract int calculateStandardBonus();

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

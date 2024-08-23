package solvd.laba.factory.employees;

import solvd.laba.factory.Money;

import java.time.LocalDate;

public class Manager extends Employee {
    protected LocalDate workingSince;

    public LocalDate getWorkingSince() {
        return workingSince;
    }

    public void setWorkingSince(LocalDate workingSince) {
        this.workingSince = workingSince;
    }

    public Manager(String name, String surname, int id, LocalDate workingSince) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.workingSince = workingSince;
    }

    @Override
    public void printPosition() {
        System.out.println("This is manager");
    }

    @Override
    public Money calculateStandardBonus(Money salary) {
        return new Money(salary.getAmount() * 0.5, salary.getCurrency());
    }

    @Override
    public String toString() {
        return "Manager " + name + " " + surname + " Id " + id + " Working since " + workingSince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        if (!super.equals(o)) return false;

        return workingSince.equals(manager.workingSince);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + workingSince.hashCode();
        return result;
    }
}

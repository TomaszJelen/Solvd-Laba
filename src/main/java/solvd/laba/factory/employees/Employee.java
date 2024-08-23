package solvd.laba.factory.employees;

import solvd.laba.factory.Person;
import solvd.laba.factory.Money;

public abstract class Employee extends Person {
    protected int id;
    //double isn't accurate enough for money but must do for now
    protected Money salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary) {
        this.salary = salary;
    }

    public abstract void printPosition();
    public abstract Money calculateStandardBonus(Money salary);

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
}

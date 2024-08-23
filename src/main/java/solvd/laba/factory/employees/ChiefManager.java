package solvd.laba.factory.employees;

import solvd.laba.factory.Money;

import java.time.LocalDate;

public class ChiefManager extends Manager{

    public ChiefManager(String name, String surname, int id, LocalDate workingSince) {
        super(name, surname, id, workingSince);
    }

    @Override
    public void printPosition() {
        System.out.println("This is chief manager");
    }

    @Override
    public Money calculateStandardBonus(Money salary) {
        return new Money(salary.getAmount() * 0.7, salary.getCurrency());
    }

    @Override
    public String toString() {
        return "Chief Manager " + name + " " + surname + " Id " + id + " Working since " + workingSince;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

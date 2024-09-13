package solvd.laba.factory.employees;

import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.exceptions.NegativeBonusException;

import java.time.LocalDate;
import java.time.Period;

public class Manager extends Employee {

    static double standardBonus;

    static {
        standardBonus = 0.5;
    }

    public Manager(String name, String surname, int id, LocalDate workingSince) {
        this.name = name;
        this.surname = surname;
        if (id < 0) {
            throw new NegativeArgumentException("Id cannot be lower than 0");
        }
        this.id = id;
        this.workingSince = workingSince;
    }

    @Override
    public void printPosition() {
        System.out.println("This is manager");
    }

    @Override
    public int calculateStandardBonus() {
        int bonus = (int) (salary * standardBonus);
        if (bonus < 0) {
            throw new NegativeBonusException("Error during calculating bonus: negative outcome");
        }
        return bonus;
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

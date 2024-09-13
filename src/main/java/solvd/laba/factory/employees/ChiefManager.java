package solvd.laba.factory.employees;

import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.exceptions.NegativeBonusException;

import java.time.LocalDate;

public class ChiefManager extends Manager{
    static double standardBonus;

    static {
        standardBonus = 0.7;
    }

    public ChiefManager(String name, String surname, int id, LocalDate workingSince) {
        super(name, surname, id, workingSince);
    }

    @Override
    public void printPosition() {
        System.out.println("This is chief manager");
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

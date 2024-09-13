package solvd.laba.factory.employees;

import solvd.laba.factory.exceptions.InvalidStringException;
import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.exceptions.NegativeBonusException;

import java.time.LocalDate;

public class Worker extends Employee {
    private String jobDescription;
    static double standardBonus;

    static {
        standardBonus = 0.25;
    }

    public Worker(String name, String surname, int id, LocalDate workingSince, String jobDescription) {
        this.name = name;
        this.surname = surname;
        if (id < 0) {
            throw new NegativeArgumentException("Id cannot be lower than 0");
        }
        this.id = id;
        this.workingSince = workingSince;
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        if (jobDescription.isEmpty()) {
            throw new InvalidStringException("Job description should not be empty");
        }
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Worker " + name + " " + surname + " Id " + id + " Task: " + jobDescription;
    }

    @Override
    public void printPosition() {
        System.out.println("This is worker");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        if (!super.equals(o)) return false;

        return jobDescription.equals(worker.jobDescription);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + jobDescription.hashCode();
        return result;
    }
}

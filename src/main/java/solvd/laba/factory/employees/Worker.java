package solvd.laba.factory.employees;

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
        this.id = id;
        this.workingSince = workingSince;
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
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
    public int calculateStandardBonus(int salary) {
        return (int) (salary * standardBonus);
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

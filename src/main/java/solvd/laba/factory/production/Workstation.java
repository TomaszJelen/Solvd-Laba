package solvd.laba.factory.production;

import solvd.laba.factory.employees.Worker;
import solvd.laba.factory.Money;

public class Workstation {
    private int id;
    private Worker worker;

    public Workstation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    Money calculateSalary() {
        return worker.getSalary();
    }

    @Override
    public String toString() {
        return "Workstation id: " + id + " used by " + worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workstation that)) return false;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

package laba.solvd.production;

import laba.solvd.people.Worker;

public class Workstation {
    int id;
    public Worker worker;

    public Workstation(int id) {
        this.id = id;
    }

    int calculateSalary() {
        return worker.getSalary();
    }
}

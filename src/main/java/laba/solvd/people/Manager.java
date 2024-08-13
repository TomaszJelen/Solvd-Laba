package laba.solvd.people;

import java.time.LocalDate;

public class Manager {
    String name;
    String surname;
    private int id;
    private LocalDate workingSince;
    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getWorkingSince() {
        return workingSince;
    }

    public void setWorkingSince(LocalDate workingSince) {
        this.workingSince = workingSince;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Manager(String name, String surname, int id, LocalDate workingSince, int salary) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.workingSince = workingSince;
        this.salary = salary;
    }

}

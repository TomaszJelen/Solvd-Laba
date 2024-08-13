package laba.solvd.people;

public class Worker {
    String name;
    String surname;
    private int id;
    private int salary;
    String jobDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Worker(String name, String surname, int id, int salary, String jobDescription) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
        this.jobDescription = jobDescription;
    }
}

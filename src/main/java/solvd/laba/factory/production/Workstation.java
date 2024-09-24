package solvd.laba.factory.production;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.employees.Employee;
import solvd.laba.factory.employees.Worker;
import solvd.laba.factory.enums.InspectionFrequency;
import solvd.laba.factory.enums.PowerConsumption;
import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.exceptions.NullArgumentException;

import java.util.Set;

public class Workstation implements EmployeeListing {
    static final Logger LOGGER = LogManager.getLogger(Workstation.class);
    private int id;
    private Worker worker;
    private InspectionFrequency inspectionFrequency;
    private PowerConsumption powerConsumption;

    public Workstation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new NegativeArgumentException("Id cannot be lower than 0");
        }
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        if (worker == null) {
            throw new NullArgumentException("Worker cannot be null");
        }
        this.worker = worker;
    }

    public InspectionFrequency getInspectionFrequency() {
        return inspectionFrequency;
    }

    public void setInspectionFrequency(InspectionFrequency inspectionFrequency) {
        this.inspectionFrequency = inspectionFrequency;
    }

    public PowerConsumption getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(PowerConsumption powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    int calculateSalary() {
        return worker.getSalary().orElseGet(() -> {
            LOGGER.info("Ignored empty salary field");
            return 0;
        });
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

    @Override
    public Set<Employee> workingEmployees() {
        return Set.of(worker);
    }
}

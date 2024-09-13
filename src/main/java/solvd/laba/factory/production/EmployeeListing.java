package solvd.laba.factory.production;

import solvd.laba.factory.employees.Employee;

import java.util.Set;

public interface EmployeeListing {
    Set<Employee> workingEmployees();
    default boolean checkIfWorkHere(Employee employee) {
        return workingEmployees().contains(employee);
    }
}

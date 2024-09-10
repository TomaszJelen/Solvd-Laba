package solvd.laba.factory.production;

import solvd.laba.factory.employees.Employee;

import java.util.Set;

public interface EmployeeListing {
    Set<Employee> workingEmployees();
    default boolean checkIfWorkHere(Employee employee) {
        if (workingEmployees().contains(employee)) {
            return true;
        }
        else {
            return false;
        }
    };

}

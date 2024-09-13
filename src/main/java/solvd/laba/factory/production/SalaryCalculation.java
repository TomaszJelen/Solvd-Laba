package solvd.laba.factory.production;

public interface SalaryCalculation extends ExpenseCalculation {
    int calculateTotalSalary();
    default int calculateTotalYearlySalary() {
        int salary = calculateTotalSalary();
        return salary * 12;
    }

    @Override
    default int calculateTotalExpense() {
        return calculateTotalSalary();
    }
}

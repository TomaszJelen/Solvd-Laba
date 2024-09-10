package solvd.laba.factory.production;

public interface ExpenseCalculation {
    int calculateTotalExpense();

    default int calculateTotalYearlyExpense() {
        int salary = calculateTotalExpense();
        return salary * 12;
    };
}

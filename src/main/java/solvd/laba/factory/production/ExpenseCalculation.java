package solvd.laba.factory.production;

public interface ExpenseCalculation {
    int calculateTotalExpense();

    default int calculateTotalYearlyExpense() {
        int expense = calculateTotalExpense();
        return expense * 12;
    }
}

package solvd.laba.factory.production;

public interface IncomeNettoCalculation {
    int calculateTotalIncomeNetto();

    default int calculateTotalYearlyIncomeNetto() {
        int salary = calculateTotalIncomeNetto();
        return salary * 12;
    }
}

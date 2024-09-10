package solvd.laba.factory.util;

import solvd.laba.factory.production.ExpenseCalculation;
import solvd.laba.factory.production.IncomeNettoCalculation;

public final class IncomeBruttoCalculation {
    static int calculateTotalIncomeBruttoOf(IncomeNettoCalculation incomeSource, ExpenseCalculation expenseSource) {
        return incomeSource.calculateTotalIncomeNetto() - expenseSource.calculateTotalExpense();
    }
    private IncomeBruttoCalculation() {
    }
}

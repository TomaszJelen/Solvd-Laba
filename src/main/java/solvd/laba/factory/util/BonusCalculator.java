package solvd.laba.factory.util;

import solvd.laba.factory.Money;

public final class BonusCalculator extends OperationsUsingInflation{
    static double ratio;
    static Money calculateBonus(Money salary) {
        return new Money(salary.getAmount() * inflation * ratio, salary.getCurrency());
    }


}

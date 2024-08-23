package solvd.laba.factory;

public class Money {
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void add(Money component) {
        this.amount += component.amount;
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;

        if (Double.compare(amount, money.amount) != 0) return false;
        return currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }
}

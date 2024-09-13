package solvd.laba.factory.product;

import solvd.laba.factory.exceptions.NegativeArgumentException;

public abstract class Product {
    protected String type;

    protected int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new NegativeArgumentException("Value cannot be lower than 0");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return type.equals(product.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}

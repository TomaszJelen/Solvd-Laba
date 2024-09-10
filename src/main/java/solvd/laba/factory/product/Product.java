package solvd.laba.factory.product;

public abstract class Product {
    protected String type;

    protected int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

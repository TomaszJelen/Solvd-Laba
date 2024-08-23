package solvd.laba.factory.product;

public abstract class Product {
    protected String type;

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

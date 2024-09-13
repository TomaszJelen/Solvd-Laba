package solvd.laba.factory.production;

import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.product.Product;

public class Storage {
    private int volume;
    private Product[] stored;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new NegativeArgumentException("Volume cannot be lower than 0");
        }
        this.volume = volume;
    }

    public Product[] getStored() {
        return stored;
    }

    public void setStored(Product[] stored) {
        this.stored = stored;
    }

    public void store(Product product) {
        Product[] extendedStored = new Product[stored.length + 1];
        System.arraycopy(stored, 0, extendedStored, 0, stored.length);
        extendedStored[extendedStored.length -1] = product;
        stored = extendedStored;
    }

    @Override
    public String toString() {
        return "Storage " + volume + " volume";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage storage)) return false;

        return volume == storage.volume;
    }

    @Override
    public int hashCode() {
        return volume;
    }


}

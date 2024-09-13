package solvd.laba.factory.organisation;

import solvd.laba.factory.exceptions.InvalidStringException;
import solvd.laba.factory.exceptions.NegativeArgumentException;

public class Location {
    private int areaSize;
    private String address;

    public Location(int areaSize, String address) {
        this.areaSize = areaSize;
        this.address = address;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        if (areaSize < 0) {
            throw new NegativeArgumentException("Size cannot be lower than 0");
        }
        this.areaSize = areaSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isEmpty()) {
            throw new InvalidStringException("Address should not be empty");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Site " + address + " Size: " + areaSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;

        if (areaSize != location.areaSize) return false;
        return address.equals(location.address);
    }

    @Override
    public int hashCode() {
        int result = areaSize;
        result = 31 * result + address.hashCode();
        return result;
    }
}

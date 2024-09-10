package solvd.laba.factory.organisation;

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
        this.areaSize = areaSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

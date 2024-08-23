package solvd.laba.factory.organisation;

public class Location {
    private int areaSize;
    private String adress;

    public Location(int areaSize, String adress) {
        this.areaSize = areaSize;
        this.adress = adress;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Site " + adress + " Size: " + areaSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;

        if (areaSize != location.areaSize) return false;
        return adress.equals(location.adress);
    }

    @Override
    public int hashCode() {
        int result = areaSize;
        result = 31 * result + adress.hashCode();
        return result;
    }
}

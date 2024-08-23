package solvd.laba.factory.organisation;

public class Supplier {
    private String name;
    private String[] parts;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Supplier " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier supplier)) return false;

        return name.equals(supplier.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

package solvd.laba.factory.organisation;

import solvd.laba.factory.production.Factory;

public class Company {
    private String name;
    private Factory[] factories;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Factory[] getFactories() {
        return factories;
    }

    public void setFactories(Factory[] factories) {
        this.factories = factories;
    }

    @Override
    public String toString() {
        return "Company " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;

        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

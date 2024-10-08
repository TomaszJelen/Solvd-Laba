package solvd.laba.factory;

import solvd.laba.factory.enums.Sex;

public abstract class Person {
    protected String name;
    protected String surname;
    protected Sex sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        if (!name.equals(person.name)) return false;
        return surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }
}

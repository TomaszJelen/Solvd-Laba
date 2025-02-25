package solvd.laba.library.model;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private Long id;
    private String name;
    private String surname;
    private List<BorrowingReservation> borrowingReservations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<BorrowingReservation> getBorrowingReservations() {
        return borrowingReservations;
    }

    public void setBorrowingReservations(List<BorrowingReservation> borrowingReservations) {
        this.borrowingReservations = borrowingReservations;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", borrowingReservations=" + borrowingReservations +
                '}';
    }
}

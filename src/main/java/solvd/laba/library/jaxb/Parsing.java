package solvd.laba.library.jaxb;

import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Room;


public class Parsing {
    public static void main(String[] args) {
        Room room = new Parser().unmarshalRoom();
        BorrowingReservation borrowingReservation = new Parser().unmarshalBorrowing();
    }
}

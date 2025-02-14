package solvd.laba.library.jaxb;

import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Room;


public class Parsing {
    public static void main(String[] args) {
        Room room = new ParserJaxb().unmarshalRoom();
        BorrowingReservation borrowingReservation = new ParserJaxb().unmarshalBorrowing();
    }
}

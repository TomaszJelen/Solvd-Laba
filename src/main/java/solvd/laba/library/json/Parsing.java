package solvd.laba.library.json;

import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Room;

public class Parsing {
    public static void main(String[] args) {
        ParserJson parserJson = new ParserJson();
        Room room = parserJson.unmarshalRoom();
        BorrowingReservation borrowingReservation = parserJson.unmarshalBorrowing();
    }
}

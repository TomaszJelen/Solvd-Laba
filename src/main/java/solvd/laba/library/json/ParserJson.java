package solvd.laba.library.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Room;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserJson {
    public Room unmarshalRoom() {
        try {
            return new ObjectMapper().readValue(new FileReader("src/main/resources/library.json"), Room.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BorrowingReservation unmarshalBorrowing() {
        try {
            return new ObjectMapper().readValue(new FileReader("src/main/resources/borrowing.json"), BorrowingReservation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

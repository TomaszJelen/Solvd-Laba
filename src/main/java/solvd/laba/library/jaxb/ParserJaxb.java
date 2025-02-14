package solvd.laba.library.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Room;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParserJaxb {
    public Room unmarshalRoom() {
        try {
            JAXBContext context = JAXBContext.newInstance(Room.class);
            return (Room) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/library.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public BorrowingReservation unmarshalBorrowing() {
        try {
            JAXBContext context = JAXBContext.newInstance(BorrowingReservation.class);
            return (BorrowingReservation) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/borrowing.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

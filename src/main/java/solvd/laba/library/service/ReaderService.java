package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoBorrowingReservation;
import solvd.laba.library.idao.IDaoReader;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Reader;
import solvd.laba.library.sql.SqlDaoBorrowingReservation;
import solvd.laba.library.sql.SqlDaoReader;


import java.sql.SQLException;
import java.util.List;

public class ReaderService {
    IDaoReader daoReader =  new SqlDaoReader();
    IDaoBorrowingReservation daoBorrowingReservation =  new SqlDaoBorrowingReservation();
    public Long createReader(Reader entity) throws SQLException, InterruptedException {
        return daoReader.create(entity).getId();
    }
    public Reader readReader(Long id) throws SQLException, InterruptedException {
        Reader reader = daoReader.read(id);
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(reader.getId())) {
            reader.getBorrowingReservations().add(borrowingReservation);
        }
        return reader;
    }
    public List<Reader> readReaders() throws SQLException, InterruptedException {
        List<Reader> readers = daoReader.readAll();
        for (Reader reader : readers) {
            for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(reader.getId())) {
                reader.getBorrowingReservations().add(borrowingReservation);
            }
        }
        return readers;
    }
    public Reader updateReader(Reader entity) throws SQLException, InterruptedException {
        Reader reader = daoReader.update(entity);
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(reader.getId())) {
            daoBorrowingReservation.remove(borrowingReservation.getId());
        }
        for (BorrowingReservation borrowingReservation : entity.getBorrowingReservations()) {
            borrowingReservation.setLibrarianId(entity.getId());
            daoBorrowingReservation.create(borrowingReservation);
        }
        return reader;
    }
    public Long removeReader(Long id) throws SQLException, InterruptedException {
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(id)) {
            daoBorrowingReservation.remove(borrowingReservation.getId());
        }
        return daoReader.remove(id);
    }
}

package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoBorrowingReservation;
import solvd.laba.library.idao.IDaoLibrarian;
import solvd.laba.library.idao.IDaoShift;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Librarian;
import solvd.laba.library.model.Shift;
import solvd.laba.library.sql.SqlDaoBorrowingReservation;
import solvd.laba.library.sql.SqlDaoLibrarian;
import solvd.laba.library.sql.SqlDaoShift;

import java.sql.SQLException;
import java.util.List;

public class LibrarianService {
    IDaoLibrarian daoLibrarian =  new SqlDaoLibrarian();
    IDaoShift daoShift =  new SqlDaoShift();
    IDaoBorrowingReservation daoBorrowingReservation =  new SqlDaoBorrowingReservation();
    public Long createLibrarian(Librarian entity) throws SQLException, InterruptedException {
        Long id = daoLibrarian.create(entity).getId();
        for (Shift shift : entity.getShifts()) {
            shift.setLibrarianId(entity.getId());
            daoShift.create(shift);
        }
//        for (BorrowingReservation borrowingReservation : entity.getBorrowingReservations()) {
//            borrowingReservation.setLibrarianId(entity.getId());
//            daoBorrowingReservation.create(borrowingReservation);
//        }
        return id;
    }
    public Librarian readLibrarian(Long id) throws SQLException, InterruptedException {
        Librarian librarian = daoLibrarian.read(id);
        for (Shift shift : daoShift.readByLibrarian(librarian.getId())) {
            librarian.getShifts().add(shift);
        }
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(librarian.getId())) {
            librarian.getBorrowingReservations().add(borrowingReservation);
        }
        return librarian;
    }
    public List<Librarian> readLibrarians() throws SQLException, InterruptedException {
        List<Librarian> librarians = daoLibrarian.readAll();
        for (Librarian librarian : librarians) {
            for (Shift shift : daoShift.readByLibrarian(librarian.getId())) {
                librarian.getShifts().add(shift);
            }
            for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(librarian.getId())) {
                librarian.getBorrowingReservations().add(borrowingReservation);
            }
        }
        return librarians;
    }
    public Librarian updateLibrarian(Librarian entity) throws SQLException, InterruptedException {
        Librarian librarian = daoLibrarian.update(entity);
        for (Shift shift : daoShift.readByLibrarian(librarian.getId())) {
            daoShift.remove(shift.getId());
        }
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(librarian.getId())) {
            daoBorrowingReservation.remove(borrowingReservation.getId());
        }
        for (Shift shift : entity.getShifts()) {
            shift.setLibrarianId(entity.getId());
            daoShift.create(shift);
        }
        for (BorrowingReservation borrowingReservation : entity.getBorrowingReservations()) {
            borrowingReservation.setLibrarianId(entity.getId());
            daoBorrowingReservation.create(borrowingReservation);
        }
        return librarian;
    }
    public Long removeLibrarian(Long id) throws SQLException, InterruptedException {
        for (Shift shift : daoShift.readByLibrarian(id)) {
            daoShift.remove(shift.getId());
        }
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByLibrarian(id)) {
            daoBorrowingReservation.remove(borrowingReservation.getId());
        }
        return daoLibrarian.remove(id);
    }
}

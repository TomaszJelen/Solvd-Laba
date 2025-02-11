package solvd.laba.library.idao;

import solvd.laba.library.model.BorrowingReservation;

import java.sql.SQLException;
import java.util.List;

public interface IDaoBorrowingReservation extends IDao<BorrowingReservation> {
    List<BorrowingReservation> readByReader(Long readerId) throws SQLException, InterruptedException;

    List<BorrowingReservation> readByBook(Long bookId) throws SQLException, InterruptedException;

    List<BorrowingReservation> readByLibrarian(Long librarianId) throws SQLException, InterruptedException;
}

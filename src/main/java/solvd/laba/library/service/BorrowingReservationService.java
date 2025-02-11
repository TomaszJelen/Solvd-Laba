package solvd.laba.library.service;


import solvd.laba.library.idao.IDaoBorrowingReservation;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.sql.SqlDaoBorrowingReservation;

import java.sql.SQLException;
import java.util.List;

public class BorrowingReservationService {
    IDaoBorrowingReservation daoBorrowingReservation =  new SqlDaoBorrowingReservation();
    public Long createBorrowingReservation(BorrowingReservation entity) throws SQLException, InterruptedException {
        return daoBorrowingReservation.create(entity).getId();
    }
    public BorrowingReservation readShift(Long id) throws SQLException, InterruptedException {
        return daoBorrowingReservation.read(id);
    }
    public List<BorrowingReservation> readShifts() throws SQLException, InterruptedException {
        return daoBorrowingReservation.readAll();
    }
    public BorrowingReservation updateShift(BorrowingReservation entity) throws SQLException, InterruptedException {
        return daoBorrowingReservation.update(entity);
    }
    public Long removeShift(Long id) throws SQLException, InterruptedException {
        return daoBorrowingReservation.remove(id);
    }
}

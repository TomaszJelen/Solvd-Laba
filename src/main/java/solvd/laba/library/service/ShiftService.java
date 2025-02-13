package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoShift;
import solvd.laba.library.model.Shift;
import solvd.laba.library.sql.SqlDaoShift;

import java.sql.SQLException;
import java.util.List;

public class ShiftService {
    IDaoShift daoShift;

    public ShiftService(IDaoShift daoShift) {
        this.daoShift = daoShift;
    }

    public Long createShift(Shift entity) throws SQLException, InterruptedException {
        return daoShift.create(entity).getId();
    }
    public Shift readShift(Long id) throws SQLException, InterruptedException {
        return daoShift.read(id);
    }
    public List<Shift> readShifts() throws SQLException, InterruptedException {
        return daoShift.readAll();
    }
    public Shift updateShift(Shift entity) throws SQLException, InterruptedException {
        return daoShift.update(entity);
    }
    public Long removeShift(Long id) throws SQLException, InterruptedException {
        return daoShift.remove(id);
    }
}

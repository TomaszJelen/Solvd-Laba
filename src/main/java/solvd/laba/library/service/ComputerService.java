package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoComputer;
import solvd.laba.library.model.Computer;
import solvd.laba.library.sql.SqlDaoComputer;

import java.sql.SQLException;
import java.util.List;

public class ComputerService {
    IDaoComputer daoComputer;

    public ComputerService(IDaoComputer daoComputer) {
        this.daoComputer = daoComputer;
    }

    public Long createComputer(Computer entity) throws SQLException, InterruptedException {
        return daoComputer.create(entity).getId();
    }
    public Computer readShift(Long id) throws SQLException, InterruptedException {
        return daoComputer.read(id);
    }
    public List<Computer> readShifts() throws SQLException, InterruptedException {
        return daoComputer.readAll();
    }
    public Computer updateShift(Computer entity) throws SQLException, InterruptedException {
        return daoComputer.update(entity);
    }
    public Long removeShift(Long id) throws SQLException, InterruptedException {
        return daoComputer.remove(id);
    }
}

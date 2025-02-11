package solvd.laba.library.idao;

import solvd.laba.library.model.Computer;

import java.sql.SQLException;
import java.util.List;

public interface IDaoComputer extends IDao<Computer> {
    List<Computer> readByRoom(Long roomId) throws SQLException, InterruptedException;
}

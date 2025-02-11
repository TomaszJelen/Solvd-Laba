package solvd.laba.library.idao;

import solvd.laba.library.model.Bookshelf;

import java.sql.SQLException;
import java.util.List;

public interface IDaoBookshelf extends IDao<Bookshelf> {
    List<Bookshelf> readByRoom(Long roomId) throws SQLException, InterruptedException;
}

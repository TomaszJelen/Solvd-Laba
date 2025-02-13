package solvd.laba.library.idao;

import solvd.laba.library.model.Genre;

import java.sql.SQLException;
import java.util.List;

public interface IDaoGenre extends IDao<Genre> {
    List<Genre> readByBook(Long bookId);
}

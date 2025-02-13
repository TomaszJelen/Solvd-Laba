package solvd.laba.library.idao;

import solvd.laba.library.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface IDaoAuthor extends IDao<Author> {
    List<Author> readByBook(Long bookId);
}

package solvd.laba.library.idao;

import solvd.laba.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IDaoBook extends IDao<Book> {
    void createConnectionToAuthors(Long bookId, Long authorId) throws SQLException, InterruptedException;

    List<Book> readByBookshelf(Long bookshelfId) throws SQLException, InterruptedException;

    void removeConnections(Long id) throws SQLException, InterruptedException;

    void createConnectionToGenres(Long bookId, Long genreId) throws SQLException, InterruptedException;
}

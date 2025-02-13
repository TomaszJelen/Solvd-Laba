package solvd.laba.library.idao;

import solvd.laba.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IDaoBook extends IDao<Book> {
    void createConnectionToAuthors(Long bookId, Long authorId);

    List<Book> readByBookshelf(Long bookshelfId);

    void removeConnections(Long id);

    void createConnectionToGenres(Long bookId, Long genreId);
}

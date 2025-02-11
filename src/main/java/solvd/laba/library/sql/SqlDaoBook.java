package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoBook;
import solvd.laba.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoBook extends SqlAbstractDao implements IDaoBook {
    @Override
    public Book create(Book entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO books (bookshelves_id, title) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getBookshelfId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong(1));
                }
            }
        }
        return entity;
    }

    @Override
    public void createConnectionToGenres(Long bookId, Long genreId) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO books_has_genres (books_id, genres_id) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, genreId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void createConnectionToAuthors(Long bookId, Long authorId) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO books_has_authors (books_id, authors_id) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, authorId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Book read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM books WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getLong("id"));
                    book.setBookshelfId(resultSet.getLong("bookshelves_id"));
                    book.setTitle(resultSet.getString("title"));
                    return book;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Book> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM books";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getLong("id"));
                    book.setBookshelfId(resultSet.getLong("bookshelves_id"));
                    book.setTitle(resultSet.getString("title"));
                    books.add(book);
                }
                return books;
            }
        }
    }

    @Override
    public List<Book> readByBookshelf(Long bookshelfId) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM books WHERE bookshelves_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, bookshelfId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getLong("id"));
                    book.setBookshelfId(resultSet.getLong("bookshelves_id"));
                    book.setTitle(resultSet.getString("title"));
                    books.add(book);
                }
                return books;
            }
        }
    }

    @Override
    public Book update(Book entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE books SET bookshelves_id = ?, title = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getBookshelfId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setLong(3, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public void removeConnections(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM books_has_authors WHERE books_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
        sqlStatement = "DELETE FROM books_has_genres WHERE books_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        removeConnections(id);
        String sqlStatement = "DELETE FROM books WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

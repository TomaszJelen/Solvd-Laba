package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoAuthor extends SqlAbstractDao implements IDaoAuthor {

    @Override
    public Author create(Author entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO authors (name, surname) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
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
    public Author read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM authors WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Author author = new Author();
                    author.setId(resultSet.getLong("id"));
                    author.setName(resultSet.getString("name"));
                    author.setSurname(resultSet.getString("surname"));
                    return author;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Author> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM authors";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Author> authors = new ArrayList<>();
                while (resultSet.next()) {
                    Author author = new Author();
                    author.setId(resultSet.getLong("id"));
                    author.setName(resultSet.getString("name"));
                    author.setSurname(resultSet.getString("surname"));
                    authors.add(author);
                }
                return authors;
            }
        }
    }

    @Override
    public List<Author> readByBook(Long bookId) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM books_has_authors WHERE books_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Author> authors = new ArrayList<>();
                while (resultSet.next()) {
                    Author author = read(resultSet.getLong("authors_id"));
                    authors.add(author);
                }
                return authors;
            }
        }
    }


    @Override
    public Author update(Author entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE authors SET name = ?, surname = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setLong(3, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM books_has_authors WHERE authors_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
        sqlStatement = "DELETE FROM authors WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

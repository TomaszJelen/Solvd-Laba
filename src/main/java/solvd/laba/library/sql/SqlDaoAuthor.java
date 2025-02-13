package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoAuthor extends SqlAbstractDao implements IDaoAuthor {

    @Override
    public Author create(Author entity) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public Author read(Long id) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> readAll() {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> readByBook(Long bookId) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Author update(Author entity) {
        String sqlStatement = "UPDATE authors SET name = ?, surname = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setLong(3, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public Long remove(Long id) {
        String sqlStatement = "DELETE FROM books_has_authors WHERE authors_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sqlStatement = "DELETE FROM authors WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}

package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoGenre extends SqlAbstractDao implements IDaoGenre {
    @Override
    public Genre create(Genre entity) {
        String sqlStatement = "INSERT INTO genres (name) VALUES (?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
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
    public Genre read(Long id) {
        String sqlStatement = "SELECT * FROM genres WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Genre genre = new Genre();
                    genre.setId(resultSet.getLong("id"));
                    genre.setName(resultSet.getString("name"));
                    return genre;
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
    public List<Genre> readAll() {
        String sqlStatement = "SELECT * FROM genres";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Genre> genres = new ArrayList<>();
                while (resultSet.next()) {
                    Genre genre = new Genre();
                    genre.setId(resultSet.getLong("id"));
                    genre.setName(resultSet.getString("name"));
                    genres.add(genre);
                }
                return genres;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> readByBook(Long bookId) {
        String sqlStatement = "SELECT * FROM books_has_genres WHERE books_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Genre> genres = new ArrayList<>();
                while (resultSet.next()) {
                    Genre genre = read(resultSet.getLong("genres_id"));
                    genres.add(genre);
                }
                return genres;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Genre update(Genre entity) {
        String sqlStatement = "UPDATE genres SET name = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
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
        String sqlStatement = "DELETE FROM books_has_genres WHERE genres_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sqlStatement = "DELETE FROM genres WHERE id = ?";
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

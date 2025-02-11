package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoGenre extends SqlAbstractDao implements IDaoGenre {
    @Override
    public Genre create(Genre entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO genres (name) VALUES (?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
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
    public Genre read(Long id) throws SQLException, InterruptedException {
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
        }
    }

    @Override
    public List<Genre> readAll() throws SQLException, InterruptedException {
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
        }
    }

    @Override
    public List<Genre> readByBook(Long bookId) throws SQLException, InterruptedException {
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
        }
    }

    @Override
    public Genre update(Genre entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE genres SET name = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM books_has_genres WHERE genres_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
         sqlStatement = "DELETE FROM genres WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

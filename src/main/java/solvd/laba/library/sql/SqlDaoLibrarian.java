package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoLibrarian;
import solvd.laba.library.model.Librarian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoLibrarian extends SqlAbstractDao implements IDaoLibrarian {
    @Override
    public Librarian create(Librarian entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO librarians (name, surname) VALUES (?, ?)";
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
    public Librarian read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM librarians WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Librarian librarian = new Librarian();
                    librarian.setId(resultSet.getLong("id"));
                    librarian.setName(resultSet.getString("name"));
                    librarian.setSurname(resultSet.getString("surname"));
                    return librarian;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Librarian> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM librarians";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Librarian> librarians = new ArrayList<>();
                while (resultSet.next()) {
                    Librarian librarian = new Librarian();
                    librarian.setId(resultSet.getLong("id"));
                    librarian.setName(resultSet.getString("name"));
                    librarian.setSurname(resultSet.getString("surname"));
                    librarians.add(librarian);
                }
                return librarians;
            }
        }
    }

    @Override
    public Librarian update(Librarian entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE librarians SET name = ?, surname = ? WHERE id = ?;";
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
        String sqlStatement = "DELETE FROM librarians WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

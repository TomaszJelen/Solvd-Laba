package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoReader;
import solvd.laba.library.model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoReader extends SqlAbstractDao implements IDaoReader {
    @Override
    public Reader create(Reader entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO readers (name, surname) VALUES (?, ?)";
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
    public Reader read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM readers WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Reader reader = new Reader();
                    reader.setId(resultSet.getLong("id"));
                    reader.setName(resultSet.getString("name"));
                    reader.setSurname(resultSet.getString("surname"));
                    return reader;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Reader> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM readers";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Reader> readers = new ArrayList<>();
                while (resultSet.next()) {
                    Reader reader = new Reader();
                    reader.setId(resultSet.getLong("id"));
                    reader.setName(resultSet.getString("name"));
                    reader.setSurname(resultSet.getString("surname"));
                    readers.add(reader);
                }
                return readers;
            }
        }
    }

    @Override
    public Reader update(Reader entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE readers SET name = ?, surname = ? WHERE id = ?;";
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
        String sqlStatement = "DELETE FROM readers WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

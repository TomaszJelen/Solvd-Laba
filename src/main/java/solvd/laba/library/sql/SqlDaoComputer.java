package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoComputer;
import solvd.laba.library.model.Bookshelf;
import solvd.laba.library.model.Computer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class SqlDaoComputer extends SqlAbstractDao implements IDaoComputer {
    @Override
    public Computer create(Computer entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO computers (rooms_id, operating_system) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getRoomId());
            preparedStatement.setString(2, entity.getOperatingSystem());
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
    public Computer read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM computers WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Computer computer = new Computer();
                    computer.setId(resultSet.getLong("id"));
                    computer.setRoomId(resultSet.getLong("rooms_id"));
                    computer.setOperatingSystem(resultSet.getString("operating_system"));
                    return computer;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Computer> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM computers";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Computer> computers = new ArrayList<>();
                while (resultSet.next()) {
                    Computer computer = new Computer();
                    computer.setId(resultSet.getLong("id"));
                    computer.setRoomId(resultSet.getLong("rooms_id"));
                    computer.setOperatingSystem(resultSet.getString("operating_system"));
                    computers.add(computer);
                }
                return computers;
            }
        }
    }

    @Override
    public List<Computer> readByRoom(Long roomId) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM computers WHERE rooms_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, roomId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Computer> computers = new ArrayList<>();
                while (resultSet.next()) {
                    Computer computer = new Computer();
                    computer.setId(resultSet.getLong("id"));
                    computer.setRoomId(resultSet.getLong("rooms_id"));
                    computer.setOperatingSystem(resultSet.getString("operating_system"));
                    computers.add(computer);
                }
                return computers;
            }
        }
    }

    @Override
    public Computer update(Computer entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE computers SET rooms_id = ?, operating_system = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getRoomId());
            preparedStatement.setString(2, entity.getOperatingSystem());
            preparedStatement.setLong(3, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM computers WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

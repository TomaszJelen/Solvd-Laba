package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoRoom;
import solvd.laba.library.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoRoom extends SqlAbstractDao implements IDaoRoom {
    @Override
    public Room create(Room entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO rooms (purpose) VALUES (?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getPurpose());
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
    public Room read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM rooms WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Room room = new Room();
                    room.setId(resultSet.getLong("id"));
                    room.setPurpose(resultSet.getString("purpose"));
                    return room;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Room> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM rooms";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Room> rooms = new ArrayList<>();
                while (resultSet.next()) {
                    Room room = new Room();
                    room.setId(resultSet.getLong("id"));
                    room.setPurpose(resultSet.getString("purpose"));
                    rooms.add(room);
                }
                return rooms;
            }
        }
    }

    @Override
    public Room update(Room entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE rooms SET purpose = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getPurpose());
            preparedStatement.setLong(2, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM rooms WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

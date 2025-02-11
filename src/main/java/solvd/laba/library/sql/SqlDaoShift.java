package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoShift;
import solvd.laba.library.model.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoShift extends SqlAbstractDao implements IDaoShift {
    @Override
    public Shift create(Shift entity) throws SQLException, InterruptedException {
        String sqlStatement = "INSERT INTO shifts (librarians_id, `from`, `to`) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getLibrarianId());
            preparedStatement.setTime(2, entity.getFrom());
            preparedStatement.setTime(3, entity.getTo());
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
    public Shift read(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM shifts WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Shift shift = new Shift();
                    shift.setId(resultSet.getLong("id"));
                    shift.setLibrarianId(resultSet.getLong("librarians_id"));
                    shift.setFrom(resultSet.getTime("from"));
                    shift.setTo(resultSet.getTime("to"));
                    return shift;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Shift> readAll() throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM shifts";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Shift> shifts = new ArrayList<>();
                while (resultSet.next()) {
                    Shift shift = new Shift();
                    shift.setId(resultSet.getLong("id"));
                    shift.setLibrarianId(resultSet.getLong("librarians_id"));
                    shift.setFrom(resultSet.getTime("from"));
                    shift.setTo(resultSet.getTime("to"));
                    shifts.add(shift);
                }
                return shifts;
            }
        }
    }

    @Override
    public List<Shift> readByLibrarian(Long librarianId) throws SQLException, InterruptedException {
        String sqlStatement = "SELECT * FROM shifts WHERE librarians_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, librarianId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Shift> shifts = new ArrayList<>();
                while (resultSet.next()) {
                    Shift shift = new Shift();
                    shift.setId(resultSet.getLong("id"));
                    shift.setLibrarianId(resultSet.getLong("librarians_id"));
                    shift.setFrom(resultSet.getTime("from"));
                    shift.setTo(resultSet.getTime("to"));
                    shifts.add(shift);
                }
                return shifts;
            }
        }
    }

    @Override
    public Shift update(Shift entity) throws SQLException, InterruptedException {
        String sqlStatement = "UPDATE shifts SET librarians_id = ?, `from` = ?, `to` = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getLibrarianId());
            preparedStatement.setTime(2, entity.getFrom());
            preparedStatement.setTime(3, entity.getTo());
            preparedStatement.setLong(4, entity.getId());
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Long remove(Long id) throws SQLException, InterruptedException {
        String sqlStatement = "DELETE FROM shifts WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            if ( preparedStatement.executeUpdate() == 0) {
                return null;
            }
        }
        return id;
    }
}

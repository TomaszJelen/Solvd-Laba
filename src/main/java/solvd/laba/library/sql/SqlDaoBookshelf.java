package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoBookshelf;
import solvd.laba.library.model.Bookshelf;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoBookshelf extends SqlAbstractDao implements IDaoBookshelf {
    @Override
    public Bookshelf create(Bookshelf entity) {
        String sqlStatement = "INSERT INTO bookshelves (rooms_id, avg_capacity) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getRoomId());
            preparedStatement.setInt(2, entity.getAvgCapacity());
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
    public Bookshelf read(Long id) {
        String sqlStatement = "SELECT * FROM bookshelves WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Bookshelf bookshelf = new Bookshelf();
                    bookshelf.setId(resultSet.getLong("id"));
                    bookshelf.setRoomId(resultSet.getLong("rooms_id"));
                    bookshelf.setAvgCapacity(resultSet.getInt("avg_capacity"));
                    return bookshelf;
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
    public List<Bookshelf> readAll() {
        String sqlStatement = "SELECT * FROM bookshelves";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Bookshelf> bookshelves = new ArrayList<>();
                while (resultSet.next()) {
                    Bookshelf bookshelf = new Bookshelf();
                    bookshelf.setId(resultSet.getLong("id"));
                    bookshelf.setRoomId(resultSet.getLong("rooms_id"));
                    bookshelf.setAvgCapacity(resultSet.getInt("avg_capacity"));
                    bookshelves.add(bookshelf);
                }
                return bookshelves;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bookshelf> readByRoom(Long roomId) {
        String sqlStatement = "SELECT * FROM bookshelves WHERE rooms_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, roomId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<Bookshelf> bookshelves = new ArrayList<>();
                while (resultSet.next()) {
                    Bookshelf bookshelf = new Bookshelf();
                    bookshelf.setId(resultSet.getLong("id"));
                    bookshelf.setRoomId(resultSet.getLong("rooms_id"));
                    bookshelf.setAvgCapacity(resultSet.getInt("avg_capacity"));
                    bookshelves.add(bookshelf);
                }
                return bookshelves;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bookshelf update(Bookshelf entity) {
        String sqlStatement = "UPDATE bookshelves SET rooms_id = ?, avg_capacity = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getRoomId());
            preparedStatement.setInt(2, entity.getAvgCapacity());
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
        String sqlStatement = "DELETE FROM bookshelves WHERE id = ?";
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

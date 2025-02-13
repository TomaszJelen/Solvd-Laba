package solvd.laba.library.sql;

import solvd.laba.library.idao.IDaoBorrowingReservation;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDaoBorrowingReservation extends SqlAbstractDao implements IDaoBorrowingReservation {
    @Override
    public BorrowingReservation create(BorrowingReservation entity) {
        String sqlStatement = "INSERT INTO `BorrowingsReservations` (readers_id, books_id, librarians_id, `from`) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getReaderId());
            preparedStatement.setLong(2, entity.getBookId());
            preparedStatement.setLong(3, entity.getLibrarianId());
            preparedStatement.setDate(4, entity.getFrom());
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
    public BorrowingReservation read(Long id) {
        String sqlStatement = "SELECT * FROM `BorrowingsReservations` WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    BorrowingReservation borrowingReservation = new BorrowingReservation();
                    borrowingReservation.setId(resultSet.getLong("id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("readers_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("books_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("librarians_id"));
                    borrowingReservation.setFrom(resultSet.getDate("from"));
                    borrowingReservation.setTo(resultSet.getDate("to"));
                    return borrowingReservation;
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
    public List<BorrowingReservation> readAll() {
        String sqlStatement = "SELECT * FROM `BorrowingsReservations`";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<BorrowingReservation> borrowingReservations = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowingReservation borrowingReservation = new BorrowingReservation();
                    borrowingReservation.setId(resultSet.getLong("id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("readers_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("books_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("librarians_id"));
                    borrowingReservation.setFrom(resultSet.getDate("from"));
                    borrowingReservation.setTo(resultSet.getDate("to"));
                    borrowingReservations.add(borrowingReservation);
                }
                return borrowingReservations;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BorrowingReservation> readByReader(Long readerId) {
        String sqlStatement = "SELECT * FROM `BorrowingsReservations` WHERE readers_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, readerId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<BorrowingReservation> borrowingReservations = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowingReservation borrowingReservation = new BorrowingReservation();
                    borrowingReservation.setId(resultSet.getLong("id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("readers_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("books_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("librarians_id"));
                    borrowingReservation.setFrom(resultSet.getDate("from"));
                    borrowingReservation.setTo(resultSet.getDate("to"));
                    borrowingReservations.add(borrowingReservation);
                }
                return borrowingReservations;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BorrowingReservation> readByBook(Long bookId) {
        String sqlStatement = "SELECT * FROM `BorrowingsReservations` WHERE books_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<BorrowingReservation> borrowingReservations = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowingReservation borrowingReservation = new BorrowingReservation();
                    borrowingReservation.setId(resultSet.getLong("id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("readers_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("books_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("librarians_id"));
                    borrowingReservation.setFrom(resultSet.getDate("from"));
                    borrowingReservation.setTo(resultSet.getDate("to"));
                    borrowingReservations.add(borrowingReservation);
                }
                return borrowingReservations;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BorrowingReservation> readByLibrarian(Long librarianId) {
        String sqlStatement = "SELECT * FROM `BorrowingsReservations` WHERE librarians_id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setLong(1, librarianId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<BorrowingReservation> borrowingReservations = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowingReservation borrowingReservation = new BorrowingReservation();
                    borrowingReservation.setId(resultSet.getLong("id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("readers_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("books_id"));
                    borrowingReservation.setLibrarianId(resultSet.getLong("librarians_id"));
                    borrowingReservation.setFrom(resultSet.getDate("from"));
                    borrowingReservation.setTo(resultSet.getDate("to"));
                    borrowingReservations.add(borrowingReservation);
                }
                return borrowingReservations;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BorrowingReservation update(BorrowingReservation entity) {
        String sqlStatement = "UPDATE `BorrowingsReservations` SET readers_id = ?, books_id = ?, librarians_id = ?, `from` = ?, `to` = ? WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getReaderId());
            preparedStatement.setLong(2, entity.getBookId());
            preparedStatement.setLong(3, entity.getLibrarianId());
            preparedStatement.setDate(4, entity.getFrom());
            preparedStatement.setDate(5, entity.getTo());
            preparedStatement.setLong(6, entity.getId());
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
        String sqlStatement = "DELETE FROM `BorrowingsReservations` WHERE id = ?";
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

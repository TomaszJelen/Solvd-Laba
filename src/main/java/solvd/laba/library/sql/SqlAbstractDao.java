package solvd.laba.library.sql;

import solvd.laba.library.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqlAbstractDao {
    public static final ConnectionPool connectionPool = ConnectionPool.getInstance(5, "jdbc:mysql://localhost:3306/library", "user", "password");
    Connection getConnection() throws SQLException, InterruptedException {
        return connectionPool.getConnection();
    }
}

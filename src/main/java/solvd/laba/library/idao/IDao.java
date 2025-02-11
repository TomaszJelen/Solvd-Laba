package solvd.laba.library.idao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T create(T entity) throws SQLException, InterruptedException;
    T read(Long id) throws SQLException, InterruptedException;
    List<T> readAll() throws SQLException, InterruptedException;
    T update(T entity) throws SQLException, InterruptedException;
    Long remove(Long id) throws SQLException, InterruptedException;
}

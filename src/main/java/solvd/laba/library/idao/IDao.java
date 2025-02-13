package solvd.laba.library.idao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T create(T entity);
    T read(Long id);
    List<T> readAll();
    T update(T entity);
    Long remove(Long id);
}

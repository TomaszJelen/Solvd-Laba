package solvd.laba.library.mybatis.IMappers;

import solvd.laba.library.idao.IDao;

public interface IMapper<T> extends IDao<T> {
    Long insert(T entity);
    Long change(T entity);

}

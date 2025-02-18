package solvd.laba.library.mybatis.IMappers;

import solvd.laba.library.idao.IDaoBookshelf;
import solvd.laba.library.model.Bookshelf;

public interface IMapperBookshelf extends IDaoBookshelf {
    Long insert(Bookshelf entity);
    Long change(Bookshelf entity);

}

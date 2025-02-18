package solvd.laba.library.mybatis.IMappers;

import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.model.Author;

public interface IMapperAuthor extends IDaoAuthor {
    Long insert(Author entity);
    Long change(Author entity);
    Long removeReference(Long id);

}

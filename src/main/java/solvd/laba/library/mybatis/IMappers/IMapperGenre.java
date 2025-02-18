package solvd.laba.library.mybatis.IMappers;


import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Genre;

public interface IMapperGenre extends IDaoGenre {
    Long insert(Genre entity);
    Long change(Genre entity);
    Long removeReference(Long id);

}

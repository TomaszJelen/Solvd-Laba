package solvd.laba.library.mybatis.IMappers;


import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Bookshelf;
import solvd.laba.library.model.Genre;

public interface IMapperGenre extends IDaoGenre, IMapper<Genre> {
    Long removeReference(Long id);

}

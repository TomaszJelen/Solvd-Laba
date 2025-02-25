package solvd.laba.library.mybatis.IMappers;


import solvd.laba.library.idao.IDaoBook;
import solvd.laba.library.model.Author;
import solvd.laba.library.model.Book;

public interface IMapperBook extends IDaoBook, IMapper<Book> {
    Long insertToGenres(Long bookId, Long genreId);
    Long insertToAuthors(Long bookId, Long authorId);
    Long removeReferenceToAuthors(Long id);
    Long removeReferenceToGenres(Long id);
}

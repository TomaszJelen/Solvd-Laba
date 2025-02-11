package solvd.laba.library.service;



import solvd.laba.library.idao.IDaoBook;
import solvd.laba.library.idao.IDaoBookshelf;
import solvd.laba.library.model.Book;
import solvd.laba.library.model.Bookshelf;
import solvd.laba.library.sql.SqlDaoBook;
import solvd.laba.library.sql.SqlDaoBookshelf;

import java.sql.SQLException;
import java.util.List;

public class BookshelfService {
    IDaoBookshelf daoBookshelf =  new SqlDaoBookshelf();
    IDaoBook daoBook =  new SqlDaoBook();
    public Long createBookshelf(Bookshelf entity) throws SQLException, InterruptedException {
        Long id = daoBookshelf.create(entity).getId();
        for (Book book : entity.getBooks()) {
            book.setBookshelfId(entity.getId());
            daoBook.create(book);
        }
        return id;
    }
    public Bookshelf readBookshelf(Long id) throws SQLException, InterruptedException {
        Bookshelf bookshelf = daoBookshelf.read(id);
        for (Book book : daoBook.readByBookshelf(bookshelf.getId())) {
            bookshelf.getBooks().add(book);
        }
        return bookshelf;
    }
    public List<Bookshelf> readBookshelfs() throws SQLException, InterruptedException {
        List<Bookshelf> bookshelves = daoBookshelf.readAll();
        for (Bookshelf bookshelf : bookshelves) {
            for (Book book : daoBook.readByBookshelf(bookshelf.getId())) {
                bookshelf.getBooks().add(book);
            }
        }
        return bookshelves;
    }
    public Bookshelf updateBookshelf(Bookshelf entity) throws SQLException, InterruptedException {
        Bookshelf bookshelf = daoBookshelf.update(entity);
        for (Book shift : daoBook.readByBookshelf(bookshelf.getId())) {
            daoBook.remove(shift.getId());
        }
        for (Book shift : entity.getBooks()) {
            shift.setBookshelfId(entity.getId());
            daoBook.create(shift);
        }
        return bookshelf;
    }
    public Long removeBookshelf(Long id) throws SQLException, InterruptedException {
        for (Book shift : daoBook.readByBookshelf(id)) {
            daoBook.remove(shift.getId());
        }
        return daoBookshelf.remove(id);
    }
}

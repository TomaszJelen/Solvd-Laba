package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.idao.IDaoBook;
import solvd.laba.library.idao.IDaoBorrowingReservation;
import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Author;
import solvd.laba.library.model.Book;
import solvd.laba.library.model.BorrowingReservation;
import solvd.laba.library.model.Genre;
import solvd.laba.library.sql.SqlDaoAuthor;
import solvd.laba.library.sql.SqlDaoBook;
import solvd.laba.library.sql.SqlDaoBorrowingReservation;
import solvd.laba.library.sql.SqlDaoGenre;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    IDaoBook daoBook =  new SqlDaoBook();
    IDaoBorrowingReservation daoBorrowingReservation =  new SqlDaoBorrowingReservation();
    IDaoGenre daoGenre =  new SqlDaoGenre();
    IDaoAuthor daoAuthor =  new SqlDaoAuthor();
    public Long createBook(Book entity) throws SQLException, InterruptedException {
        Long id = daoBook.create(entity).getId();
        for (Genre genre : entity.getGenres()) {
            daoBook.createConnectionToGenres(id, genre.getId());
        }
        for (Author author : entity.getAuthors()) {
            daoBook.createConnectionToAuthors(id, author.getId());
        }
        return id;
    }
    public Book readBook(Long id) throws SQLException, InterruptedException {
        Book book = daoBook.read(id);
        for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByBook(book.getId())) {
            book.getBorrowingReservations().add(borrowingReservation);
        }
        for (Genre genre : daoGenre.readByBook(book.getId())) {
            book.getGenres().add(genre);
        }
        for (Author author : daoAuthor.readByBook(book.getId())) {
            book.getAuthors().add(author);
        }
        return book;
    }
    public List<Book> readBooks() throws SQLException, InterruptedException {
        List<Book> librarians = daoBook.readAll();
        for (Book book : librarians) {
            for (BorrowingReservation borrowingReservation : daoBorrowingReservation.readByBook(book.getId())) {
                book.getBorrowingReservations().add(borrowingReservation);
            }
            for (Genre genre : daoGenre.readByBook(book.getId())) {
                book.getGenres().add(genre);
            }
            for (Author author : daoAuthor.readByBook(book.getId())) {
                book.getAuthors().add(author);
            }
        }
        return librarians;
    }
    public Book updateBook(Book entity) throws SQLException, InterruptedException {
        Book book = daoBook.update(entity);
        for (BorrowingReservation computer : daoBorrowingReservation.readByBook(book.getId())) {
            daoBorrowingReservation.remove(computer.getId());
        }
        daoBook.removeConnections(book.getId());
        for (BorrowingReservation borrowingReservation : entity.getBorrowingReservations()) {
            borrowingReservation.setBookId(entity.getId());
            daoBorrowingReservation.create(borrowingReservation);
        }
        for (Genre genre : entity.getGenres()) {
            daoBook.createConnectionToGenres(entity.getId(), genre.getId());
        }
        for (Author author : entity.getAuthors()) {
            daoBook.createConnectionToAuthors(entity.getId(), author.getId());
        }
        return book;
    }
    public Long removeBook(Long id) throws SQLException, InterruptedException {
        for (BorrowingReservation computer : daoBorrowingReservation.readByBook(id)) {
            daoBorrowingReservation.remove(computer.getId());
        }
        return daoBook.remove(id);
    }
}

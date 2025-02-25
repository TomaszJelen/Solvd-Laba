package solvd.laba.library;

import solvd.laba.library.model.*;
import solvd.laba.library.mybatis.*;
import solvd.laba.library.service.*;
import solvd.laba.library.sql.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

//        Room room = new Room();
//        room.setPurpose("Extra2 room");
//        RoomService roomService = new RoomService(new MyBatisDaoRoom(), new SqlDaoComputer(), new MyBatisDaoBookshelf());
//        roomService.createRoom(room);
//        System.out.println(room.getId());
//        List<Room> rooms = roomService.readRooms();
        MyBatisDaoBookshelf daoBookshelf = new MyBatisDaoBookshelf();
        MyBatisDaoBook daoBook = new MyBatisDaoBook();
        MyBatisDaoAuthor daoAuthor = new MyBatisDaoAuthor();
        MyBatisDaoGenre daoGenre = new MyBatisDaoGenre();
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setAvgCapacity(250);
        BookshelfService bookshelfService = new BookshelfService(daoBookshelf, daoBook);
        bookshelfService.createBookshelf(bookshelf);
        bookshelfService.removeBookshelf(bookshelf.getId());

//        new BookService(daoBook, null, daoGenre, daoAuthor);
//        new RoomService(new MyBatisDaoRoom(), null, daoBookshelf);
//        System.out.println("debug");
        Author author1 = new Author();
        author1.setName("William");
        author1.setSurname("Error");
        AuthorService authorService = new AuthorService(daoAuthor);
        authorService.createAuthor(author1);
        System.out.println(authorService.readAuthor(author1.getId()));
        author1.setSurname("Shakespear");
        authorService.updateAuthor(author1);
        authorService.readAuthors().forEach(System.out::println);
        authorService.removeAuthor(author1.getId());

        Genre genre1 = new Genre();
        genre1.setName("dra");
        GenreService genreService = new GenreService(daoGenre);
        genreService.createGenre(genre1);
        System.out.println(genreService.readGenre(genre1.getId()));
        genre1.setName("drama");
        genreService.updateGenre(genre1);
        genreService.readGenres().forEach(System.out::println);
        genreService.removeGenre(genre1.getId());

//        Room room = new Room();
//        room.setPurpose("Main room");
//        new RoomService(new SqlDaoRoom(), new SqlDaoComputer(), new SqlDaoBookshelf()).createRoom(room);
//
//        Bookshelf bookshelf = new Bookshelf();
//        bookshelf.setAvgCapacity(1000);
//        room.getBookshelves().add(bookshelf);
//        bookshelf.setRoomId(room.getId());
//        new BookshelfService(new SqlDaoBookshelf(), new SqlDaoBook()).createBookshelf(bookshelf);
//
//        Book book1 = new Book();
//        book1.setTitle("Divine comedy");
//        Author author1 = new Author();
//        author1.setName("Dante");
//        author1.setSurname("Alighieri");
//        new AuthorService(new SqlDaoAuthor()).createAuthor(author1);
//        Genre genre1 = new Genre();
//        genre1.setName("fiction");
//        new GenreService(new SqlDaoGenre()).createGenre(genre1);
//        book1.getAuthors().add(author1);
//        book1.getGenres().add(genre1);
//        bookshelf.getBooks().add(book1);
//        book1.setBookshelfId(bookshelf.getId());
//        new BookService(new SqlDaoBook(), new SqlDaoBorrowingReservation(), new SqlDaoGenre(), new SqlDaoAuthor()).createBook(book1);
//
//
//
//        System.out.println("Room: " + room.getId());
//        System.out.println("Bookshelf: " + bookshelf.getId());
//        System.out.println("Book: " + book1.getId());
//        System.out.println("Author: " + author1.getId());
//        System.out.println("Genre: " + genre1.getId());
//        Room newRoom = new RoomService(new SqlDaoRoom(), new SqlDaoComputer(), new SqlDaoBookshelf()).readRoom(room.getId());
//        Book newBook = new BookService(new SqlDaoBook(), new SqlDaoBorrowingReservation(), new SqlDaoGenre(), new SqlDaoAuthor()).readBook(book1.getId());
////        Author author = new Author();
////        author.setName("Adam");
////        author.setSurname("Mickiewicz");
////        SqlDaoAuthor sqlDaoAuthor = new SqlDaoAuthor();
////        Author aut = sqlDaoAuthor.create(author);
////        System.out.println(aut.getId());
    }
}

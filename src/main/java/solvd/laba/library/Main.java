package solvd.laba.library;

import solvd.laba.library.model.*;
import solvd.laba.library.service.*;
import solvd.laba.library.sql.SqlDaoAuthor;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Room room = new Room();
        room.setPurpose("Main room");
        new RoomService().createRoom(room);

        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setAvgCapacity(1000);
        room.getBookshelves().add(bookshelf);
        bookshelf.setRoomId(room.getId());
        new BookshelfService().createBookshelf(bookshelf);

        Book book1 = new Book();
        book1.setTitle("Divine comedy");
        Author author1 = new Author();
        author1.setName("Dante");
        author1.setSurname("Alighieri");
        new AuthorService().createAuthor(author1);
        Genre genre1 = new Genre();
        genre1.setName("fiction");
        new GenreService().createGenre(genre1);
        book1.getAuthors().add(author1);
        book1.getGenres().add(genre1);
        bookshelf.getBooks().add(book1);
        book1.setBookshelfId(bookshelf.getId());
        new BookService().createBook(book1);



        System.out.println("Room: " + room.getId());
        System.out.println("Bookshelf: " + bookshelf.getId());
        System.out.println("Book: " + book1.getId());
        System.out.println("Author: " + author1.getId());
        System.out.println("Genre: " + genre1.getId());
        Room newRoom = new RoomService().readRoom(room.getId());
        Book newBook = new BookService().readBook(book1.getId());
//        Author author = new Author();
//        author.setName("Adam");
//        author.setSurname("Mickiewicz");
//        SqlDaoAuthor sqlDaoAuthor = new SqlDaoAuthor();
//        Author aut = sqlDaoAuthor.create(author);
//        System.out.println(aut.getId());
    }
}

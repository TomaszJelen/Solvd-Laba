package solvd.laba.library.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import solvd.laba.library.model.*;

import java.util.ArrayList;
import java.util.List;

public class RoomHandler extends DefaultHandler {
    public static final String ROOM = "Room";
    public static final String BOOKSHELF = "Bookshelf";
    public static final String BOOK = "Book";
    public static final String AUTHOR = "Author";
    public static final String GENRE = "Genre";
    private Room room;
    private StringBuilder elementValue;
    private List<String> xmlContext = new ArrayList<>();

    public Room getRoom() {
        return room;
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() {
        room = new Room();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        xmlContext.add(qName);
        Bookshelf bookshelf = null;
        Book book = null;
        switch (qName) {
            case "bookshelves":
                room.setBookshelves(new ArrayList<>());
                break;
            case BOOKSHELF:
                room.getBookshelves().add(new Bookshelf());
                break;
            case "books":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                bookshelf.setBooks(new ArrayList<>());
                break;
            case BOOK:
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                bookshelf.getBooks().add(new Book());
                break;
            case "authors":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                book.setAuthors(new ArrayList<>());
                break;
            case AUTHOR:
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                book.getAuthors().add(new Author());
                break;
            case "genres":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                book.setGenres(new ArrayList());
                break;
            case GENRE:
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                book.getGenres().add(new Genre());
                break;
            default:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        xmlContext.remove(xmlContext.size() -1);
        Bookshelf bookshelf = null;
        Book book = null;
        Author author = null;
        Genre genre = null;
        switch (qName) {
            case "id":
                switch (xmlContext.get(xmlContext.size() - 1)) {
                    case ROOM:
                        room.setId(Long.valueOf(elementValue.toString()));
                        break;
                    case BOOKSHELF:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        bookshelf.setId(Long.valueOf(elementValue.toString()));
                        break;
                    case BOOK:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                        book.setId(Long.valueOf(elementValue.toString()));
                        break;
                    case AUTHOR:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                        author = book.getAuthors().get(book.getAuthors().size() - 1);
                        author.setId(Long.valueOf(elementValue.toString()));
                        break;
                    case GENRE:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                        genre = book.getGenres().get(book.getGenres().size() - 1);
                        genre.setId(Long.valueOf(elementValue.toString()));
                        break;
                }
                break;
            case "purpose":
                room.setPurpose(elementValue.toString());
                break;
            case "avgCapacity":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                bookshelf.setAvgCapacity(Integer.valueOf(elementValue.toString()));
                break;
            case "title":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                book.setTitle(elementValue.toString());
                break;
            case "name":
                switch (xmlContext.get(xmlContext.size() - 1)) {
                    case AUTHOR:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                        author = book.getAuthors().get(book.getAuthors().size() - 1);
                        author.setName(elementValue.toString());
                        break;
                    case GENRE:
                        bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                        book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                        genre = book.getGenres().get(book.getGenres().size() - 1);
                        genre.setName(elementValue.toString());
                        break;
                }
                break;
            case "surname":
                bookshelf = room.getBookshelves().get(room.getBookshelves().size() - 1);
                book = bookshelf.getBooks().get(bookshelf.getBooks().size() - 1);
                author = book.getAuthors().get(book.getAuthors().size() - 1);
                author.setSurname(elementValue.toString());
                break;
        }
    }
}

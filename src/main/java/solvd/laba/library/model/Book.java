package solvd.laba.library.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<BorrowingReservation> borrowingReservations = new ArrayList<>();
    private Long bookshelfId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<BorrowingReservation> getBorrowingReservations() {
        return borrowingReservations;
    }

    public void setBorrowingReservations(List<BorrowingReservation> borrowingReservations) {
        this.borrowingReservations = borrowingReservations;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }
}

package solvd.laba.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @JsonProperty
    @XmlElement(name = "id")
    private Long id;
    @JsonProperty
    @XmlElement(name = "title")
    private String title;
    @JsonProperty
    @XmlElementWrapper(name = "authors")
    @XmlElement(name = "Author")
    private List<Author> authors = new ArrayList<>();
    @JsonProperty
    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "Genre")
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                ", borrowingReservations=" + borrowingReservations +
                ", bookshelfId=" + bookshelfId +
                '}';
    }
}

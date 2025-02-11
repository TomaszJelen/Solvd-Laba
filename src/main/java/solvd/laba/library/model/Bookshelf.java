package solvd.laba.library.model;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private Long id;
    private Integer avgCapacity;
    private List<Book> books = new ArrayList<>();
    private Long roomId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvgCapacity() {
        return avgCapacity;
    }

    public void setAvgCapacity(Integer avgCapacity) {
        this.avgCapacity = avgCapacity;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}

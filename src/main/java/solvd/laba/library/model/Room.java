package solvd.laba.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    @JsonProperty
    @XmlElement(name = "id")
    private Long id;
    @JsonProperty
    @XmlElement(name = "purpose")
    private String purpose;
    private List<Computer> computers = new ArrayList<>();
    @JsonProperty
    @XmlElementWrapper(name = "bookshelves")
    @XmlElement(name = "Bookshelf")
    private List<Bookshelf> bookshelves = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", computers=" + computers +
                ", bookshelves=" + bookshelves +
                '}';
    }
}

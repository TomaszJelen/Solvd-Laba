package solvd.laba.library.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import solvd.laba.library.jaxb.DateAdapter;

import java.sql.Date;

@XmlRootElement(name = "BorrowingReservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingReservation {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "from")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date from;
    @XmlElement(name = "to")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date to;
    private Long readerId;
    private Long bookId;
    private Long librarianId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Long librarianId) {
        this.librarianId = librarianId;
    }
}

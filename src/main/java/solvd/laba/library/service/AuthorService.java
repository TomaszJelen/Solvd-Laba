package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.model.Author;
import solvd.laba.library.sql.SqlDaoAuthor;

import java.sql.SQLException;
import java.util.List;

public class AuthorService {
    IDaoAuthor daoAuthor;

    public AuthorService(IDaoAuthor daoAuthor) {
        this.daoAuthor = daoAuthor;
    }

    public Long createAuthor(Author entity) throws SQLException, InterruptedException {
        return daoAuthor.create(entity).getId();
    }
    public Author readAuthor(Long id) throws SQLException, InterruptedException {
        return daoAuthor.read(id);
    }
    public List<Author> readAuthors() throws SQLException, InterruptedException {
        return daoAuthor.readAll();
    }
    public Author updateAuthor(Author entity) throws SQLException, InterruptedException {
        return daoAuthor.update(entity);
    }
    public Long removeAuthor(Long id) throws SQLException, InterruptedException {
        return daoAuthor.remove(id);
    }
}

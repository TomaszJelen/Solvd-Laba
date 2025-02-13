package solvd.laba.library.service;

import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Genre;
import solvd.laba.library.sql.SqlDaoGenre;

import java.sql.SQLException;
import java.util.List;

public class GenreService {
    IDaoGenre daoGenre;

    public GenreService(IDaoGenre daoGenre) {
        this.daoGenre = daoGenre;
    }

    public Long createGenre(Genre entity) throws SQLException, InterruptedException {
        return daoGenre.create(entity).getId();
    }
    public Genre readGenre(Long id) throws SQLException, InterruptedException {
        return daoGenre.read(id);
    }
    public List<Genre> readGenres() throws SQLException, InterruptedException {
        return daoGenre.readAll();
    }
    public Genre updateGenre(Genre entity) throws SQLException, InterruptedException {
        return daoGenre.update(entity);
    }
    public Long removeGenre(Long id) throws SQLException, InterruptedException {
        return daoGenre.remove(id);
    }
}

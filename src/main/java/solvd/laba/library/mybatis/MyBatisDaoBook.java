package solvd.laba.library.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.idao.IDaoBook;
import solvd.laba.library.model.Book;
import solvd.laba.library.mybatis.IMappers.IMapperBook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoBook implements IDaoBook {
    @Override
    public Book create(Book entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.insert(entity);
                session.commit();
                return entity;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book read(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                return iDaoBook.read(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> readAll() {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                return iDaoBook.readAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book update(Book entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.change(entity);
                session.commit();
                return entity;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long remove(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.remove(id);
                session.commit();
                return id;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createConnectionToAuthors(Long bookId, Long authorId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.insertToAuthors(bookId, authorId);
                session.commit();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> readByBookshelf(Long bookshelfId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                return iDaoBook.readByBookshelf(bookshelfId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeConnections(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.removeReferenceToAuthors(id);
                iDaoBook.removeReferenceToGenres(id);
                session.commit();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void createConnectionToGenres(Long bookId, Long genreId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBook iDaoBook = session.getMapper(IMapperBook.class);
                iDaoBook.insertToGenres(bookId, genreId);
                session.commit();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

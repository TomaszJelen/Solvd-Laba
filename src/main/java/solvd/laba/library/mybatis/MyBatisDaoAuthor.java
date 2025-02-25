package solvd.laba.library.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.idao.IDaoAuthor;
import solvd.laba.library.model.Author;
import solvd.laba.library.mybatis.IMappers.IMapperAuthor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoAuthor extends MyBatisDao<Author, IMapperAuthor> implements IDaoAuthor {

//    @Override
//    public Author create(Author entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
//                iDaoAuthor.insert(entity);
//                session.commit();
//                return entity;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Author read(Long id) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
//                return iDaoAuthor.read(id);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<Author> readAll() {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
//                return iDaoAuthor.readAll();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Author update(Author entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
//                iDaoAuthor.change(entity);
//                session.commit();
//                return entity;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public Long remove(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
                iDaoAuthor.removeReference(id);
                iDaoAuthor.remove(id);
                session.commit();
                return id;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> readByBook(Long bookId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperAuthor iDaoAuthor = session.getMapper(IMapperAuthor.class);
                return iDaoAuthor.readByBook(bookId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

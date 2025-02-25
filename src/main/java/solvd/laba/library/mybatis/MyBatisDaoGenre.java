package solvd.laba.library.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.idao.IDaoGenre;
import solvd.laba.library.model.Genre;
import solvd.laba.library.mybatis.IMappers.IMapperGenre;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoGenre extends MyBatisDao<Genre, IMapperGenre> implements IDaoGenre {

//    @Override
//    public Genre create(Genre entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
//                iDaoGenre.insert(entity);
//                session.commit();
//                return entity;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Genre read(Long id) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
//                return iDaoGenre.read(id);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<Genre> readAll() {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
//                return iDaoGenre.readAll();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Genre update(Genre entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
//                iDaoGenre.change(entity);
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
                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
                iDaoGenre.removeReference(id);
                iDaoGenre.remove(id);
                session.commit();
                return id;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> readByBook(Long bookId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperGenre iDaoGenre = session.getMapper(IMapperGenre.class);
                return iDaoGenre.readByBook(bookId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

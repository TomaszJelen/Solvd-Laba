package solvd.laba.library.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.idao.IDaoBookshelf;
import solvd.laba.library.model.Bookshelf;
import solvd.laba.library.mybatis.IMappers.IMapperBookshelf;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoBookshelf extends MyBatisDao<Bookshelf, IMapperBookshelf> implements IDaoBookshelf {
//    @Override
//    public Bookshelf create(Bookshelf entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
//                iDaoBookshelf.insert(entity);
//                session.commit();
//                return entity;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Bookshelf read(Long id) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
//                return iDaoBookshelf.read(id);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<Bookshelf> readAll() {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
//                return iDaoBookshelf.readAll();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Bookshelf update(Bookshelf entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
//                iDaoBookshelf.change(entity);
//                session.commit();
//                return entity;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Long remove(Long id) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
//                iDaoBookshelf.remove(id);
//                session.commit();
//                return id;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public List<Bookshelf> readByRoom(Long roomId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperBookshelf iDaoBookshelf = session.getMapper(IMapperBookshelf.class);
                return iDaoBookshelf.readByRoom(roomId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

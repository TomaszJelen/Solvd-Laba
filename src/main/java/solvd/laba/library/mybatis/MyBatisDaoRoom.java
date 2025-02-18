package solvd.laba.library.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.idao.IDaoRoom;
import solvd.laba.library.mybatis.IMappers.IMapperRoom;
import solvd.laba.library.model.Room;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoRoom implements IDaoRoom {
    @Override
    public Room create(Room entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
                iDaoRoom.insert(entity);
                session.commit();
                return entity;
//                session.insert()
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room read(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
                return iDaoRoom.read(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Room> readAll() {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
                return iDaoRoom.readAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room update(Room entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
                iDaoRoom.change(entity);
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
                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
                iDaoRoom.remove(id);
                session.commit();
                return id;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package solvd.laba.library.mybatis;

import solvd.laba.library.idao.IDaoRoom;
import solvd.laba.library.mybatis.IMappers.IMapperRoom;
import solvd.laba.library.model.Room;


public class MyBatisDaoRoom extends MyBatisDao<Room, IMapperRoom> implements IDaoRoom {
//    @Override
//    public Room create(Room entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
////            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
//                iDaoRoom.insert(entity);
//                session.commit();
//                return entity;
////                session.insert()
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Room read(Long id) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
//                return iDaoRoom.read(id);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<Room> readAll() {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
//                return iDaoRoom.readAll();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Room update(Room entity) {
//        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            try (SqlSession session = build.openSession()) {
//                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
//                iDaoRoom.change(entity);
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
//                IMapperRoom iDaoRoom = session.getMapper(IMapperRoom.class);
//                iDaoRoom.remove(id);
//                session.commit();
//                return id;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

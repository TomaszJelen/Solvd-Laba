package solvd.laba.library.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.laba.library.mybatis.IMappers.IMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class MyBatisDao<T, I extends IMapper> {
    private Class<I> clazz;
    public Class<I> getClazz() {
        return this.clazz;
    }

    public T create(T entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                I iDaoT = session.getMapper(getClazz());
                iDaoT.insert(entity);
                session.commit();
                return entity;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T read(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                I iDaoT = session.getMapper(getClazz());
                return (T) iDaoT.read(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> readAll() {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                I iDaoT = session.getMapper(getClazz());
                return iDaoT.readAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T update(T entity) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                I iDaoT = session.getMapper(getClazz());
                iDaoT.change(entity);
                session.commit();
                return entity;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Long remove(Long id) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                I iDaoT = session.getMapper(getClazz());
                iDaoT.remove(id);
                session.commit();
                return id;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

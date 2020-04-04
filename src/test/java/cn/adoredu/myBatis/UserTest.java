package cn.adoredu.myBatis;

import cn.adoredu.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    private SqlSessionFactory sqlSessionFactory;

    // 创建工厂
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 根据id查询用户（单条记录）
    @Test
    public void testOne() {
        // 创建SqlSesion
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 操作数据库 1. statement位置（namespace.id），2. 传入的参数
        User user = null;
        try {
            user = sqlSession.selectOne("usermapper.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(user);
    }

    // 根据名称查询（多条记录）
    @Test
    public void testList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("usermapper.findUserByName", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(userList);
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("Tom");
        user.setAddress("sz");
        user.setBirthday(new Date());
        user.setSex("1");
        try {
            sqlSession.insert("usermapper.insertUser", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        System.out.println(user.getId());
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("usermapper.deleteById", 28);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(27);
        user.setBirthday(new Date());
        user.setSex("2");
        user.setUsername("Jerry");
        user.setAddress("bj");
        try {
            sqlSession.update("usermapper.updateUser", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}

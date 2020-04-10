package cn.adoredu.myBatis;

import cn.adoredu.mybatis.mapper.UserMapper;
import cn.adoredu.mybatis.po.User;
import cn.adoredu.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testOne() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用代理对象的方法
        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByResultMap("小明");
        sqlSession.close();
        System.out.println(userList);
    }

    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        User user = new User();
        user.setUsername("小明");
        user.setSex("1");
        userQueryVo.setUser(user);
        userQueryVo.setIds(ids);
        List<User> userList = userMapper.findUserList(userQueryVo);
        sqlSession.close();
        System.out.println(userList);
    }

    @Test
    public void testDelete() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteById(27);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testCache() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper = sqlSession2.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        User user1 = mapper.findUserById(1);
//        User user2 = userMapper.findUserById(2);
    }
}

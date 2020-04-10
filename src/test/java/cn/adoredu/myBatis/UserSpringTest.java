package cn.adoredu.myBatis;

import cn.adoredu.mybatis.dao.UserDao;
import cn.adoredu.mybatis.mapper.UserMapper;
import cn.adoredu.mybatis.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSpringTest {

    private ApplicationContext context;

    @Before
    public void init() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testDao() throws Exception {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testMapper() throws Exception {
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

}

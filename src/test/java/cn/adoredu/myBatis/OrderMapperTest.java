package cn.adoredu.myBatis;

import cn.adoredu.mybatis.mapper.OrderMapperCustom;
import cn.adoredu.mybatis.po.OrderCustom;
import cn.adoredu.mybatis.po.Orders;
import cn.adoredu.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapperCustom mapper = sqlSession.getMapper(OrderMapperCustom.class);
        List<OrderCustom> orderUserList = mapper.findOrderUserList();
        sqlSession.close();
        System.out.println(orderUserList);
    }

    @Test
    public void testResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapperCustom mapper = sqlSession.getMapper(OrderMapperCustom.class);
        List<Orders> ordersList = mapper.findOrderUserResultMap();
        System.out.println(ordersList);
    }

    @Test
    public void testOrdersOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapperCustom mapper = sqlSession.getMapper(OrderMapperCustom.class);
        List<Orders> ordersList = mapper.findOrdersOrderDetailMap();
        System.out.println(ordersList);
    }

    @Test
    public void testOrdersOrderDetailResultMapLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapperCustom mapper = sqlSession.getMapper(OrderMapperCustom.class);
        List<Orders> ordersList = mapper.findOrdersUserLazyLoading();
        User user = ordersList.get(0).getUser();
//        System.out.println(ordersList);
    }
}

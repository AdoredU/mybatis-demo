package cn.adoredu.mybatis.mapper;

import cn.adoredu.mybatis.po.OrderCustom;
import cn.adoredu.mybatis.po.Orders;

import java.util.List;

public interface OrderMapperCustom {

    List<OrderCustom> findOrderUserList() throws Exception;

    List<Orders> findOrderUserResultMap() throws Exception;

    List<Orders> findOrdersOrderDetailMap() throws Exception;

    List<Orders> findOrdersUserLazyLoading() throws Exception;
}

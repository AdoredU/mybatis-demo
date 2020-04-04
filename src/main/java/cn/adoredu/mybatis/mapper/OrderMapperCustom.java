package cn.adoredu.mybatis.mapper;

import cn.adoredu.mybatis.po.OrderCustom;

import java.util.List;

public interface OrderMapperCustom {

    List<OrderCustom> findOrderUserList() throws Exception;
}

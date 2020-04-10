package cn.adoredu.mybatis.dao;

import cn.adoredu.mybatis.po.User;

public interface UserDao {

    User findUserById(int id) throws Exception;
}

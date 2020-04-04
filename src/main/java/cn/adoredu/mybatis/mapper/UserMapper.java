package cn.adoredu.mybatis.mapper;

import cn.adoredu.mybatis.po.User;
import cn.adoredu.mybatis.po.UserQueryVo;

import java.util.List;

public interface UserMapper {

    User findUserById(int id) throws Exception;

    List<User> findUserByName(String username) throws Exception;

    List<User> findUserByResultMap(String username) throws Exception;

    List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    void insertUser(User user) throws Exception;

    void deleteById(int id) throws Exception;

    void updateUser(User user) throws Exception;
}

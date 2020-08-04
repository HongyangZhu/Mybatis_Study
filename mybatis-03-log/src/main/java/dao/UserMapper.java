package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserByID(int id);

    //插入用户
    int addUser(User user);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}

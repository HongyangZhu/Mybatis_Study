package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
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

    //用万能Map插入用户
    void addUser2(Map<String, Object> map);

    //模糊查询
    List<User> getUserLike(String value);
}

package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    @Select("select * from USER")
    List<User> getUserList();

    //根据ID查询用户
    @Select("select * from USER where ID= #{id} and NAME= #{name}")
    User getUserById(@Param("id") int id, @Param("name") String name);

    //插入用户
    @Insert("insert into USER (ID, NAME, PWD)  values (#{id}, #{name}, #{pwd})")
    int addUser(User user);

    //更新用户
    @Update("update USER set NAME=#{name}, PWD=#{pwd} where ID = #{id}")
    int updateUser(User user);

    //删除用户
    @Delete(" delete from USER where ID = #{id}")
    int deleteUser(int id);

}

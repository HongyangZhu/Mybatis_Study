import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class helloTest {
    @Test
    public void test_getUserList() {
        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2.执行SQL
        // 方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test_getUserByID() {
        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByID(1);
        System.out.println(user);
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test_addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "黑子", "666");
        mapper.addUser(user);
        //增删改一定要提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test_updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "黑子", "777");
        mapper.updateUser(user);
        //增删改一定要提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test_deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        //增删改一定要提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

}

import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class helloTest {
    @Test
    public void Test_getUsers() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void Test_getUserById() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1, "Tom");
        System.out.println(user);
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

import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class helloTest {
    @Test
    public void test() {

        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2.执行SQL
        // 方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }
}

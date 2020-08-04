import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;

import java.util.HashMap;
import java.util.List;

public class helloTest {
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);
        }
    }
}

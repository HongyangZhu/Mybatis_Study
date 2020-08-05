import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherTest {
    @Test
    public void getTeacher() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher(1));
        sqlSession.close();
    }
}

import dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;

import java.util.List;

public class StudentTest {
    @Test
    public void Test_getStudentALL() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentALL = mapper.getStudentALL();
        for (Student student : studentALL) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void Test_getStudentALL2() {
        SqlSession sqlSession = utils.MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentALL = mapper.getStudentALL2();
        for (Student student : studentALL) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}

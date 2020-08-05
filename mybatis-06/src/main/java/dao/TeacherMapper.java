package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;

public interface TeacherMapper {

    @Select("SELECT * FROM teacher where id =#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}

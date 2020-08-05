package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;
import pojo.Teacher2;

public interface TeacherMapper {

    @Select("SELECT * FROM teacher where id =#{tid}")
    Teacher getTeacher(@Param("tid") int id);

    //获取指定老师下的所有学生以及老师的信息
    Teacher2 getTeacherALL(@Param("tid") int id);

}

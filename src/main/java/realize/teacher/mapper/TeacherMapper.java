package realize.teacher.mapper;

import realize.student.dao.Student;
import realize.teacher.dao.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacher(Teacher teacher);
    List<Teacher> getCourse(String teacherNo);

    List<Student> getStudent(String teacherNo);
}
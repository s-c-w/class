package realize.student.mapper;

import realize.classroom.dao.Course;
import realize.student.dao.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudent(String stuNo);
    List<Course> getCourse(String stuNo);

    void sign(String stuNo,String courseNo ,String courseMessage );

    void solitaire(String stuNo, String courseMessage, String courseNo);
}

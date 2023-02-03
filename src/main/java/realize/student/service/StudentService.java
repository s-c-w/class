package realize.student.service;

import realize.classroom.dao.Course;
import realize.student.dao.Student;
import java.util.List;
public interface StudentService {
    Student getStudent(String stuNo);
    List<Course> getCourse(String stuNo);
}

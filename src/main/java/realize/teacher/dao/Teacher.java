package realize.teacher.dao;

import lombok.Data;
import realize.classroom.dao.Course;

import java.io.Serializable;
import java.util.List;

@Data
public class Teacher implements Serializable {
    private String teacherNo;
    private String teacherName;
    private List<Course> courseList;
}

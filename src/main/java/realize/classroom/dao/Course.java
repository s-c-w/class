package realize.classroom.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Course implements Serializable {
    private String courseNo;
    private String courseName;
    private String courseCredit;
    private String coursePlace;
    private String courseTeacher;
    private List<CourseWeekTime> courseWeekTimes;
}

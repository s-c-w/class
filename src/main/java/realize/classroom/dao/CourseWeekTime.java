package realize.classroom.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseWeekTime implements Serializable {
    private String courseWeek;
    private String courseTime;
    private String courseNum;
}

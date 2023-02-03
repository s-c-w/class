package realize.classroom.service;

import org.springframework.stereotype.Service;
import realize.classroom.dao.Course;
import realize.classroom.mapper.CourseMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Resource
    private CourseMapper courseMapper;


    public List<Course> getList(){
        return courseMapper.getList();
    }
}

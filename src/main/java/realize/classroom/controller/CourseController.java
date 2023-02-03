package realize.classroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realize.classroom.dao.Course;
import realize.classroom.service.CourseService;
import vo.Result;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /**
     * 获取课程信息，完成生成课程表与日程关联
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<Course> getList(){
        return courseService.getList();
    }
}

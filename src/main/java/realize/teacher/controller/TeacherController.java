package realize.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import realize.student.dao.Student;
import realize.teacher.dao.Teacher;
import realize.teacher.service.TeacherService;
import vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 教师端功能
 * 查看本课程下的学生
 * 课程安排
 * 开始上课
 * 下课
 * 发起签到
 * 发起接龙
 * 查看每一堂课的签到情况 包括签到人数 签到学生
 * 查看每一堂课的接龙情况 包括接龙人数 接龙学生
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师登录
     * @param teacher
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public Result<Object> login(Teacher teacher,HttpSession session){
        Teacher teacher1=teacherService.getTeacher(teacher);
        if(teacher1!=null){
            session.setAttribute("teacher",teacher1);
            return Result.success("登录成功");
        }
        return Result.fail("用户名或密码错误");
    }

    /**
     * 查看本课程下的学生
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/student")
    public Result<Object> getStudent(HttpSession session){
       // Teacher teacher1=(Teacher)session.getAttribute("teacher");
        Teacher teacher1=new Teacher();
        teacher1.setTeacherNo("0000000001");
        List<Student> studentList=teacherService.getStudent(teacher1.getTeacherNo());
        return Result.success(studentList);
    }

    /**
     * 课程安排
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/course")
    public Result<Object> getCourse(HttpSession session){
//        Teacher teacher1=(Teacher)session.getAttribute("teacher");
        Teacher teacher1=new Teacher();
        teacher1.setTeacherNo("0000000001");
        List<Teacher> teacherList=teacherService.getCourse(teacher1.getTeacherNo());
        return Result.success(teacherList);
    }
    /**
     * 开始上课
     */
    @ResponseBody
    @PostMapping("/begin/{courseNo}")
    public Result<Object> begin(@PathVariable("courseNo")String courseNo){
        teacherService.begin(courseNo);
        return Result.success("已上课");
    }
    /**
     * 下课
     */
    @ResponseBody
    @PostMapping("/end/{courseNo}")
    public Result<Object> end(@PathVariable("courseNo")String courseNo){
        teacherService.end(courseNo);
        return Result.success("已下课");
    }

    /**
     * 发起签到
     *查看每一堂课的签到情况 包括签到人数 签到学生
     */
    @ResponseBody
    @PostMapping("/sign/{courseNo}")
    public Result<Object> sign(@PathVariable("courseNo")String courseNo){
        List<Student> students= teacherService.sign(courseNo);
        return Result.success(students);
    }
    /**
     * 发起接龙
     * 查看每一堂课的接龙情况 包括接龙人数 接龙学生
     */
    @ResponseBody
    @PostMapping("/solitaire/{courseNo}")
    public Result<Object> solitaire(@PathVariable("courseNo")String courseNo){
        List<Student> students= teacherService.solitaire(courseNo);
        return Result.success(students);
    }
}

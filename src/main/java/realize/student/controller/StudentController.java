package realize.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import realize.classroom.dao.Course;
import realize.student.dao.Student;
import realize.student.service.StudentService;
import vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 学生模块的功能有
 * 登录
 * 课表查询
 * 课堂签到
 * 接龙
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 学生登录 用学号和手机号登录
     * @param stu
     * @return
     */
@ResponseBody
@PostMapping("/login")
    public Result<Object> getStudent(Student stu, HttpSession session){
         Student student=studentService.getStudent(stu.getStuNo());
         if(student!=null){
             BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
             boolean match=encoder.matches(stu.getStuTelephone(),student.getStuTelephone());
             if(match){
                 session.setAttribute("student",stu);
                 return Result.success("登录成功");
             }
             return Result.fail("学号或手机号错误");
         }
         return Result.fail("学号或手机号错误");
    }

    /**
     * 学生查询自己的课程表 包括授课教师 授课地点 课程名称
     * 例如 学生卢丽伉 本学期的课表为
     * 操作系统 刘咏梅 北校区研究生楼210
     * 编译原理 班志杰 北校区研究生楼201
     * 网络原理与开发技术 李乌云格日乐 北校区研究生楼201
     * 毛泽东思想和中国特色社会主义理论体系概论（一） 赵秀娥 北校区卓越楼315
     */
    @ResponseBody
    @GetMapping("/course")
    public List<Course> getCourse(HttpSession session){
        //Student student=(Student)session.getAttribute("student");
        Student student=new Student();
        student.setStuNo("0191123484");
        student.setStuTelephone("18739399165");
        String stuNo=student.getStuNo();
        return studentService.getCourse(stuNo);
    }
    /**
     * 课堂签到
     * 例如在操作系统课程上 签到限时为10分钟 在10分钟内点击签到即为签到成功
     */
    @ResponseBody
    @PostMapping("/sign/{courseNo}")
    public Result<Object> sign(@PathVariable("courseNo")String courseNo,String courseMessage,String stuNo){
        studentService.sign(stuNo,courseNo,courseMessage);
        return Result.success("签到成功");
    }
    /**
     * 学生接龙
     * 例如在操作系统课程上 班长发起已完成作业接龙 每个同学点击接龙即实现接龙
     */
    @ResponseBody
    @PostMapping("/solitaire/{courseNo}")
    public Result<Object> solitaire(@PathVariable("courseNo")String courseNo,String courseMessage,String stuNo){
        studentService.solitaire(stuNo,courseMessage,courseNo);
        return Result.success("接龙成功");
    }
}

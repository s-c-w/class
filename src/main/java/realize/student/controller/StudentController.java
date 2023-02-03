package realize.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realize.classroom.dao.Course;
import realize.student.dao.Student;
import realize.student.service.StudentService;
import vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 学生登录
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
     * 学生查询自己的课程表
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
}

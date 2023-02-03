package realize.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realize.student.dao.Student;
import realize.teacher.dao.Teacher;
import realize.teacher.service.TeacherService;
import vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

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

    @ResponseBody
    @GetMapping("/student")
    public Result<Object> getStudent(HttpSession session){
       // Teacher teacher1=(Teacher)session.getAttribute("teacher");
        Teacher teacher1=new Teacher();
        teacher1.setTeacherNo("0000000001");
        List<Student> studentList=teacherService.getStudent(teacher1.getTeacherNo());
        return Result.success(studentList);
    }
    @ResponseBody
    @GetMapping("/course")
    public Result<Object> getCourse(HttpSession session){
//        Teacher teacher1=(Teacher)session.getAttribute("teacher");
        Teacher teacher1=new Teacher();
        teacher1.setTeacherNo("0000000001");
        List<Teacher> teacherList=teacherService.getCourse(teacher1.getTeacherNo());
        return Result.success(teacherList);
    }

}

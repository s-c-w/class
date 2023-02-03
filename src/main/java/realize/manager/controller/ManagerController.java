package realize.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realize.manager.dao.Manager;
import realize.manager.service.ManagerService;
import realize.student.dao.Student;
import vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 管理员登录
     * @param manager
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public Result<Object> login(Manager manager, HttpSession session){
        Manager manager1= managerService.getManager(manager);
        if(manager1!=null){
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            boolean match=encoder.matches(manager.getManagerPassword(),manager1.getManagerPassword());
            if(match){
                manager1.setManagerPassword(null);
                session.setAttribute("manager",manager1);
                return Result.success("登录成功");
            }
            return  Result.fail("用户名或密码错误");
        }
        return Result.fail("用户名或密码错误");
    }

    @ResponseBody
    @GetMapping("/student")
    public List<Student> StudentSelect(){
        return managerService.getStudent();
    }
}

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import realize.classroom.controller.CourseController;
import realize.manager.dao.Manager;
import realize.manager.mapper.ManagerMapper;
import realize.manager.service.ManagerService;

import javax.annotation.Resource;


public class Test1 {
    @Test
    public void test1(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("1131245601"));
    }
    @Test
    public void test2(){

    }
}

package realize.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realize.manager.dao.Manager;
import realize.manager.mapper.ManagerMapper;
import realize.student.dao.Student;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerMapper managerMapper;
    @Override
    public Manager getManager(Manager manager) {
        return managerMapper.getManager(manager);
    }

    @Override
    public List<Student> getStudent() {
        return managerMapper.getStudent();
    }
}

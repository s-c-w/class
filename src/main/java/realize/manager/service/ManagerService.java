package realize.manager.service;

import realize.manager.dao.Manager;
import realize.student.dao.Student;

import java.util.List;

public interface ManagerService {
    Manager getManager(Manager manager);
    List<Student> getStudent();
}

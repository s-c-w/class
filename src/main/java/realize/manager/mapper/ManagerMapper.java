package realize.manager.mapper;

import realize.manager.dao.Manager;
import realize.student.dao.Student;

import java.util.List;

public interface ManagerMapper {
    Manager getManager(Manager manager);

    List<Student> getStudent();
}

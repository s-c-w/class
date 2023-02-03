package realize.teacher.service;

import org.springframework.stereotype.Service;
import realize.student.dao.Student;
import realize.teacher.dao.Teacher;
import realize.teacher.mapper.TeacherMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public Teacher getTeacher(Teacher teacher) {
        return teacherMapper.getTeacher(teacher);
    }

    @Override
    public List<Teacher> getCourse(String teacherNo) {
        return teacherMapper.getCourse(teacherNo);
    }

    @Override
    public List<Student> getStudent(String teacherNo) {
        return teacherMapper.getStudent(teacherNo);
    }
}

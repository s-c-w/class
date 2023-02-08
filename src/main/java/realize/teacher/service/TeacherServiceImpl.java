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

    @Override
    public void begin(String courseNo) {
        teacherMapper.begin(courseNo);
    }

    @Override
    public void end(String courseNo) {
        teacherMapper.end(courseNo);
    }

    @Override
    public List<Student> sign(String courseNo) {
        return teacherMapper.sign(courseNo);
    }

    @Override
    public List<Student> solitaire(String courseNo) {
        return teacherMapper.solitaire(courseNo);
    }
}

package realize.student.service;

import org.springframework.stereotype.Service;
import realize.classroom.dao.Course;
import realize.student.dao.Student;
import realize.student.mapper.StudentMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student getStudent(String stuNo) {
        return studentMapper.getStudent(stuNo);
    }

    @Override
    public List<Course> getCourse(String stuNo) {
        return studentMapper.getCourse(stuNo);
    }

    @Override
    public void sign(String stuNo,String courseNo, String courseMessage) {
        studentMapper.sign(stuNo,courseNo,courseMessage);
    }

    @Override
    public void solitaire(String stuNo, String courseMessage, String courseNo) {
        studentMapper.solitaire(stuNo,courseMessage,courseNo);
    }
}

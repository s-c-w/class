package realize.student.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private String stuName;
    private String stuNo;
    private String stuTelephone;
    private Date stuBirth;
    private String stuSex;
    private Byte stuAge;
}

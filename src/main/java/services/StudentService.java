package services;

import models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THANH NGA on 6/28/2017.
 */
@Repository
public class StudentService {
    public List<Student> GetAll(){
        Student st = new Student("Nga","HCM");
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(st);
        return list;
    }
}

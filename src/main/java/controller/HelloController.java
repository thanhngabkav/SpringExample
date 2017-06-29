package controller;

import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.StudentService;

import java.util.List;

/**
 * Created by THANH NGA on 6/27/2017.
 */
@RestController
public class HelloController {

    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/hello")
    public ResponseEntity<List<Student>> getStudent(){
        //Call service
        List<Student> studentList = studentService.GetAll();
        ResponseEntity<List<Student>> response = new ResponseEntity<>(studentList, HttpStatus.OK);
        return response;
    }

}

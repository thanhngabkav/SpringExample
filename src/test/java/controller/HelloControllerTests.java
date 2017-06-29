package controller;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import services.StudentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
@ContextConfiguration(classes = DemoApplication.class)
public class HelloControllerTests {

	@Autowired
	private MockMvc mvc;
	@MockBean
    private StudentService studentService;
	@Before
    public void setUp(){
        Student st = new Student("Nga","HCM");
        ArrayList<Student> list = new ArrayList<>();
        list.add(st);
        when(studentService.GetAll()).thenReturn(list);
    }

    @Test
    public void contextLoads() throws Exception {
        Student st = new Student("Nga","HCM");
        List<Student> list = new ArrayList<Student>();
        list.add(st);
        ObjectMapper objectMapper = new ObjectMapper();
        String st_json = objectMapper.writeValueAsString(list);
        // System.out.println(st_json);
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(st_json));
        verify(studentService,times(1)).GetAll();
    }

}

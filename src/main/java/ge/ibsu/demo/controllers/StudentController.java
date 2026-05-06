package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.TopStudentDto;
import ge.ibsu.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/top")
    public List<TopStudentDto> getTop() {
        return studentService.getTopStudents();
    }
}

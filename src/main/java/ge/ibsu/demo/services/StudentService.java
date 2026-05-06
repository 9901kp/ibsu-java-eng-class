package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.TopStudentDto;
import ge.ibsu.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<TopStudentDto> getTopStudents() {
        return studentRepository.findTopStudents();
    }
}

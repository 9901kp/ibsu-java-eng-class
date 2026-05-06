package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.TopStudentDto;
import ge.ibsu.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new ge.ibsu.demo.dto.TopStudentDto(s.fullName, s.grade, f.name) " +
            "FROM Student s JOIN s.faculty f " +
            "WHERE s.grade > (SELECT AVG(s2.grade) FROM Student s2)")
    List<TopStudentDto> findTopStudents();
}

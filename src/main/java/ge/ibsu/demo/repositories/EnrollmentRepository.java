package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.EnrollmentView;
import ge.ibsu.demo.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Query("SELECT s.fullName AS studentFullName, c.title AS courseTitle, e.enrollmentDate AS enrollmentDate " +
            "FROM Enrollment e JOIN e.student s JOIN e.course c")
    List<EnrollmentView> findAllEnrollmentViews();
}

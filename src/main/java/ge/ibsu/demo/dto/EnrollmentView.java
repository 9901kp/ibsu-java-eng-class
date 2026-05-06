package ge.ibsu.demo.dto;
import java.time.LocalDate;

public interface EnrollmentView {
    String getStudentFullName();
    String getCourseTitle();
    LocalDate getEnrollmentDate();
}

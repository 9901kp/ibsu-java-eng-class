package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.EnrollmentView;
import ge.ibsu.demo.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<EnrollmentView> getAllEnrollments() {
        return enrollmentRepository.findAllEnrollmentViews();
    }
}

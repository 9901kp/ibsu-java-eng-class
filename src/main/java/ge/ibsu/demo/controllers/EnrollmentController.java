package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.EnrollmentView;
import ge.ibsu.demo.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentView> getEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}

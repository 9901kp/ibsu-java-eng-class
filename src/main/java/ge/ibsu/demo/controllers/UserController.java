package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.UserSummary;
import ge.ibsu.demo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ge.ibsu.demo.services.UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/active")
    public List<UserSummary> getActiveUsers() {
        return userService.getActiveUsers();
    }
}
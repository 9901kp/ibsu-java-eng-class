package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.AuthenticationResponse;
import ge.ibsu.demo.dto.LoginData;
import ge.ibsu.demo.dto.RegistrationRequest;
import ge.ibsu.demo.dto.UserSummary;
import ge.ibsu.demo.entities.User;
import ge.ibsu.demo.repositories.UserRepository;
import ge.ibsu.demo.security.config.JwtService;
import ge.ibsu.demo.utils.GeneralUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegistrationRequest data) throws Exception {
        GeneralUtil.checkRequiredProperties(data, List.of("firstName", "lastName", "email", "password"));
        User user = new User();
        GeneralUtil.getCopyOf(data, user, "password");
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        this.repository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse login(LoginData data) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        data.getUsername(),
                        data.getPassword())
        );
        var user = repository.findByEmail(data.getUsername())
                .orElseThrow(
                        () ->  new UsernameNotFoundException("USER_NOT_FOUND")
                );
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public List<UserSummary> getActiveUsers() {
        return userRepository.findActiveUsersSummary();
    }
}
package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.UserSummary;
import ge.ibsu.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u.name as name, u.email as email FROM User u WHERE u.status = 'active'")
    List<UserSummary> findActiveUsersSummary();

}
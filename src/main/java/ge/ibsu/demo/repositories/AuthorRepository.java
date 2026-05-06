package ge.ibsu.demo.repositories;
import ge.ibsu.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

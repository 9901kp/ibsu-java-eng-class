package ge.ibsu.demo.repositories;
import ge.ibsu.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.author.name = :name")
    List<Book> findByAuthorName(@Param("name") String name);
}

package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Product;
import ge.ibsu.demo.dto.ProductStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.твоя_папка.ProductStats(p.category, AVG(p.price)) " +
            "FROM Product p GROUP BY p.category")
    List<ProductStats> findAveragePriceByCategory();
}